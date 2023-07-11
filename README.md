<h1>Java 11 | Selenium | TestNG | Maven | POM | Allure report | Integration with TMS Qase </h1>
<p>This is a sample Java 11 Adopt Open JDK | Selenium WebDriver | Maven | TestNG | project created in IntelliJ IDE, using Page Object Model and Generic Type.</p>
<p>Website <a href="https://dev.swisscows.com">https://dev.swisscows.com/</a>&nbsp;was used to create functional, API, and UI tests.</p>

<p><strong>pom.xml dependencies used:</strong></p>
<blockquote>
<dependencies>
    
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.7.1</version>
        </dependency>
        
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.10.0</version>
        </dependency>
        
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.3.3</version>
        </dependency>
        
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.10</version>
        </dependency>
        
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.14.1</version>
        </dependency>
        
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.3.0</version>
            <scope>test</scope>
        </dependency>
        
        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20220924</version>
            <scope>test</scope>
        </dependency>
        
        <dependency>
            <groupId>org.apache.pdfbox</groupId>
            <artifactId>pdfbox</artifactId>
            <version>2.0.26</version>
        </dependency>
        
        <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-testng</artifactId>
            <version>2.20.1</version>
            <scope>test</scope>
        </dependency>
        
        <dependency>
            <groupId>io.qase</groupId>
            <artifactId>qase-testng</artifactId>
            <version>3.0.5</version>
            <scope>test</scope>
        </dependency>
        
    </dependencies>
</blockquote>
<h1>API testing in progress</h1>
<p>For testing requests and responses&nbsp;<strong>DevTools&nbsp;type property</strong> was used&nbsp;</p>
<blockquote>
<pre>&nbsp; DevTools devTools;<br /><br /></pre>
</blockquote>
<p><strong>setUpDevTool(WebDriver driver)&nbsp;</strong> method was created in the class CaptureNetworkTraffic &nbsp;to capture the traffic:</p>
<blockquote>
<pre><br />public&nbsp;CaptureNetworkTraffic setUpDevTool(WebDriver driver) {<br />&nbsp; &nbsp; &nbsp;devTools&nbsp;= ((ChromeDriver) driver).getDevTools();<br />&nbsp; &nbsp; &nbsp;devTools.createSession();<br />&nbsp; &nbsp; &nbsp;devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));<br />&nbsp;<br />&nbsp; &nbsp; &nbsp;return this;<br />&nbsp;}&nbsp;</pre>
</blockquote>
<p><strong>org.openqa.selenium.devtools.v106.network.Network</strong>&nbsp;was used for traffic interception.</p>
<p>Class&nbsp;<strong>HttpURLConnection</strong>&nbsp;was used to send direct API calls and check responses.<br /><br /><strong>Rest Assured</strong> library and&nbsp;<strong>POJO Model</strong> was used for testing and validating REST APIs.</p>
<h1>Setup the project and execute tests locally</h1>
<p>1. Install IntelliJ IDE:<br /><a href="https://www.jetbrains.com/help/idea/installation-guide.html">https://www.jetbrains.com/help/idea/installation-guide.html</a></p>
<p>2. Copy the HTTPS project link from the GitHub repository:&nbsp;<br /><a href="https://github.com/ant0d0v/SwisscowsDev.git">https://github.com/ant0d0v/SwisscowsDev.git</a></p>
<p>3. Clone a repository from the main menu:&nbsp;<br /><a title="https://www.jetbrains.com/help/idea/cloning-repository.html#clone_project_from_main_screen" href="https://www.jetbrains.com/help/idea/cloning-repository.html#clone_project_from_main_screen">https://www.jetbrains.com/help/idea/cloning-repository.html#clone_project_from_main_screen</a></p>
<p>4. Go to the resources package, and copy local.properties.TEMPLATE file. Paste it to the resources package, and re-name the new file as&nbsp;local.properties</p>
<p>5. Execute test class or single test by opening the Test class, right-clicking on the green triangle, and choosing Run</p>
