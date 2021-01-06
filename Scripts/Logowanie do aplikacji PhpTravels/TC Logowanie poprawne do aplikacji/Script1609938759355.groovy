import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

// Uruchomienie przeglądarki z adresem aplikacji Phptravels
WebUI.openBrowser(rawUrl=GlobalVariable.url)
// Zmiana rozmiaru przegladarki
WebUI.maximizeWindow()
// Rozwiniecie listy MyAccount
WebUI.click(findTestObject('Object Repository/PageLogin/acc_dropdown_menu'))
// Klikniecie przycisku Logowania
WebUI.click(findTestObject('Object Repository/PageLogin/btn_login'))

// Wprowadzenie Email
WebUI.setText(findTestObject('Object Repository/PageLogin/inp_login_email'), GlobalVariable.LoginId)
// Kliknecie przycisku Login
WebUI.click(findTestObject('Object Repository/PageLogin/btn_login_2'))
// Wpisanie hasła
WebUI.setEncryptedText(findTestObject('Object Repository/PageLogin/inp_pwd'),GlobalVariable.pwd)
// Zalogowanie sie
WebUI.click(findTestObject('Object Repository/PageLogin/btn_login_2'))
WebUI.delay(3);
// Klikniecie przycisku MyProfile 
WebUI.click(findTestObject('Object Repository/PageDesktop/btn_myprofile'))
// Załadownie pliku csv
TestData dataFromFile = findTestData("Data Files/MyProfile_Dane")
// Wypenianie forumlarza danymi
WebUI.setText(findTestObject('Object Repository/PageMyProfile/input_email'),dataFromFile.getObjectValue("Email", 1))
WebUI.setText(findTestObject('Object Repository/PageMyProfile/input_pwd'),dataFromFile.getObjectValue("Password", 1))
WebUI.setText(findTestObject('Object Repository/PageMyProfile/input_pwd_confirm'),dataFromFile.getObjectValue("Password", 1))
WebUI.setText(findTestObject('Object Repository/PageMyProfile/input_address'),dataFromFile.getObjectValue("Address", 1))
WebUI.setText(findTestObject('Object Repository/PageMyProfile/input_city'),dataFromFile.getObjectValue("City", 1))
WebUI.setText(findTestObject('Object Repository/PageMyProfile/input_zipcode'),dataFromFile.getObjectValue("Zip-Code", 1))
WebUI.setText(findTestObject('Object Repository/PageMyProfile/input_phone'),dataFromFile.getObjectValue("Phone", 1))
WebUI.delay(3);
WebUI.click(findTestObject('Object Repository/PageMyProfile/btn_submit'))
// Wylogowanie z konta
WebUI.click(findTestObject('Object Repository/PageDesktop/btn_demo_dropdown'))
WebUI.click(findTestObject('Object Repository/PageDesktop/btn_logout'))
WebUI.delay(2);
WebUI.closeBrowser();
