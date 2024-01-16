package GenericUtility;

import java.util.Random;

public class JavaUtility {
public int getRandomNo()
{
	Random ran=new Random();
	return ran.nextInt(1000);
}
}
