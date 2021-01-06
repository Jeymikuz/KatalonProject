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
// Klikniecie przycisku Logowania
WebUI.click(findTestObject('Object Repository/Automationpractice Objects/PageLogin/btn_SignIn'))
// Wprowadzenie danych logowania oraz zatwierdzenie
WebUI.setText(findTestObject('Object Repository/Automationpractice Objects/PageLogin/input_email'), GlobalVariable.LoginId)
WebUI.setEncryptedText(findTestObject('Object Repository/Automationpractice Objects/PageLogin/input_pwd'),GlobalVariable.pwd)
WebUI.click(findTestObject('Object Repository/Automationpractice Objects/PageLogin/btn_submit'))
// Wyszukaj produkt
WebUI.setText(findTestObject('Automationpractice Objects/PageLogin/input_search'), GlobalVariable.product)
WebUI.click(findTestObject('Object Repository/Automationpractice Objects/PageLogin/btn_search'))
// Wejdz do znalezionego produktu i dodaj do koszyka
WebUI.click(findTestObject('Object Repository/Automationpractice Objects/PageProduct/btn_product'))
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Automationpractice Objects/PageProduct/btn_addToCart'))
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Automationpractice Objects/PageProduct/btn_Proceed'))
// 
WebUI.click(findTestObject('Object Repository/Automationpractice Objects/PageSubmitOrder/btn_proceed'))
WebUI.setText(findTestObject('Automationpractice Objects/PageSubmitOrder/textField_orderComment'), "TEST")
WebUI.click(findTestObject('Object Repository/Automationpractice Objects/PageSubmitOrder/btn_proceed_2'))
WebUI.click(findTestObject('Object Repository/Automationpractice Objects/PageSubmitOrder/btn_TermsOfService'))
WebUI.click(findTestObject('Object Repository/Automationpractice Objects/PageSubmitOrder/btn_proceed_3'))
WebUI.click(findTestObject('Object Repository/Automationpractice Objects/PageSubmitOrder/btn_PayByBankWire'))
WebUI.click(findTestObject('Object Repository/Automationpractice Objects/PageSubmitOrder/btn_proceed_4'))

String msgConfirmOrder = WebUI.getText(findTestObject('Object Repository/Automationpractice Objects/PageSubmitOrder/text_OrderConfirm'))
if(msgConfirmOrder=='Your order on My Store is complete.')
{
	println ('Zamowienie kompletne')
}
else{
	println ('Blad zamowienia')
}
WebUI.click(findTestObject('Object Repository/Automationpractice Objects/PageSubmitOrder/btn_logout'))

WebUI.closeBrowser();
