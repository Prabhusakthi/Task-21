package Task21;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	public class DragandDrop {

	    public static void main(String[] args) {
	        // Set the path for the ChromeDriver
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kaleeswari\\eclipse-workspace\\Task21\\src\\main\\java\\Task21\\chromedriver.exe");

	        // Initialize the ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        try {
	            // Maximize the browser window
	            driver.manage().window().maximize();

	            // Navigate to the jQuery UI Droppable demo
	            driver.get("https://jqueryui.com/droppable/");

	            // Wait for the page to load
	            Thread.sleep(100000000);

	            // Switch to the iframe containing the draggable and droppable elements
	            WebElement iframe = driver.findElement(By.className("demo-frame"));
	            driver.switchTo().frame(iframe);

	            // Locate the source element ("Drag me to my target")
	            WebElement sourceElement = driver.findElement(By.id("draggable"));

	            // Locate the target element ("Drop here")
	            WebElement targetElement = driver.findElement(By.id("droppable"));

	            // Perform drag and drop from source element to target element
	            Actions actions = new Actions(driver);
	            actions.dragAndDrop(sourceElement, targetElement).perform();

	            // Wait for the drag-and-drop action to complete
	            Thread.sleep(2000);

	            // Verify the drag-and-drop was successful by checking the CSS color property
	            String backgroundColor = targetElement.getCssValue("background-color");
	            System.out.println("Background Color after Drop: " + backgroundColor);

	            // Verify the text of the target element has changed to "Dropped!"
	            String targetText = targetElement.getText();
	            System.out.println("Target Element Text: " + targetText);

	            if ("Dropped!".equals(targetText)) {
	                System.out.println("Drag and drop successful.");
	            } else {
	                System.out.println("Drag and drop failed.");
	            }

	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser window and quit the WebDriver instance
	            driver.quit();
	        }
	    }
	}



