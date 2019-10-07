import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://client1705.idosell.com/panel/user/login')

WebUI.setText(findTestObject('Login/Page_Login/input_Login_login'), 'autoTester')

WebUI.setEncryptedText(findTestObject('Login/Page_Login/input_Haso_password'), 'RigbBhfdqOBGNlJIWM1ClA==')

WebUI.click(findTestObject('Login/Page_Login/button_Zaloguj si'))

isElement = WebUI.verifyElementPresent(findTestObject('Login/Page_Login/div_Bdny login lub haso'), 1, FailureHandling.OPTIONAL)

'Wrong password exception'
if (isElement == true) {
    WebUI.setText(findTestObject('Login/Page_Login/input_Login_login'), 'autoTester')

    WebUI.setEncryptedText(findTestObject('Login/Page_Login/input_Haso_password'), 'RigbBhfdqODKcAsiUrg+1Q==')

    WebUI.click(findTestObject('Login/Page_Login/button_Zaloguj si'))

    'issue'
    WebUI.verifyElementNotPresent(findTestObject('Login/Page_Login/div_Bdny login lub haso'), 1)
}

isElement = WebUI.verifyElementPresent(findTestObject('Login/Page_Login_ChangePass/h1_Zmiana hasa'), 1, FailureHandling.OPTIONAL)

'Change password exception\nChoose second'
if (isElement == true) {
    WebUI.setEncryptedText(findTestObject('Login/Page_Login_ChangePass/input_Podaj nowe haso_password'), 'RigbBhfdqODKcAsiUrg+1Q==')

    WebUI.setEncryptedText(findTestObject('Login/Page_Login_ChangePass/input_Powtrz nowe haso_confirm_password'), 'RigbBhfdqODKcAsiUrg+1Q==')

    WebUI.click(findTestObject('Login/Page_Login_ChangePass/input_Powtrz nowe haso_btn no-border btn-primary'))

    isElement = WebUI.verifyElementVisible(findTestObject('Login/Page_Login_ChangePass/div_Podaj haso ktre jest inne ni obecne'), 
        FailureHandling.STOP_ON_FAILURE)

    'Change password again\nChoose first\n'
    if (isElement == true) {
        WebUI.setEncryptedText(findTestObject('Login/Page_Login_ChangePass/input_Podaj nowe haso_password'), 'RigbBhfdqOBGNlJIWM1ClA==')

        WebUI.setEncryptedText(findTestObject('Login/Page_Login_ChangePass/input_Powtrz nowe haso_confirm_password'), 'RigbBhfdqOBGNlJIWM1ClA==')

        WebUI.click(findTestObject('Login/Page_Login_ChangePass/input_Powtrz nowe haso_btn no-border btn-primary'))

        'issue\n'
    }
}

WebUI.closeBrowser()

