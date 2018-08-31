import java.util.regex.*;
public class AntiVirus{
  
  private int scanIntensity = 0;
  
  //this method is ready for you.
  public void setScanIntensity(int level){
    scanIntensity = level;
  }
  
  //write this method.
  public String scanFile(File file,VirusDB database){  
  
    Boolean result = false;
    String data_of_file = file.getData();
    String[] database_strings_1 ;
    String[] database_strings_2;
    String[] database_strings_3;
    
    switch(this.scanIntensity)
    {
      case 0:
        result = true;
        break;
      case 1:
        database_strings_1 = database.getSignatures(1);
        result = isSafe(database_strings_1,data_of_file);
        break;
      case 2:
        database_strings_1 = database.getSignatures(1);
        database_strings_2 = database.getSignatures(2);
        
        result = isSafe(database_strings_1,data_of_file) && isSafe(database_strings_2,data_of_file);
        
        break;
      case 3:
        database_strings_1 = database.getSignatures(1);
        database_strings_2 = database.getSignatures(2);
        database_strings_3 = database.getSignatures(3);
        
        result = isSafe(database_strings_1,data_of_file) && isSafe(database_strings_2,data_of_file) && isSafe(database_strings_3,data_of_file);
        break;
    }

      if(!result)
      {
        return file.getName() + " is not safe";
      }
    
    return file.getName() + " is safe";
  }
  
  public boolean isSafe(String[] database_strings,String data_of_file)
  {
    for(String currentpattern : database_strings)
    {
      String regex = "[\\w]*" + currentpattern + "[\\w]*" ;
      Pattern myPattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
      Matcher mymatcher = myPattern.matcher(data_of_file);
      if(mymatcher.find())
      {
        return false;
      }
    }
    
    return true;
  }
}