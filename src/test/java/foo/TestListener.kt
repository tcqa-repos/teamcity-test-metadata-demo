package foo

import org.testng.IInvokedMethod
import org.testng.IInvokedMethodListener
import org.testng.ITestResult

class TestListener: IInvokedMethodListener {
    override fun beforeInvocation(method: IInvokedMethod?, testResult: ITestResult?) {
        // do nothing
    }

    override fun afterInvocation(method: IInvokedMethod?, testResult: ITestResult?) {
        publishScreenshot()
    }

    private fun publishScreenshot() {
        println("##teamcity[publishArtifacts 'new folder/pictureForAttention.png => screenshots.zip/']")
        println("##teamcity[testMetadata type='image' value='screenshots.zip!pictureForAttention.png']")
    }
}
