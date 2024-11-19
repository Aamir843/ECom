package dev.akhtar.ProductService.exceptions;


public class NoSuchCategoryExistsException extends RuntimeException{
    public NoSuchCategoryExistsException(String message){
        super(message);
    }
/**
 1. Extending RuntimeException
    If your custom exception class extends RuntimeException, it becomes an unchecked exception.
    Unchecked exceptions do not need to be declared in the throws clause of a method.
    This is because unchecked exceptions are meant to indicate programming errors, such as invalid arguments
    or logical flaws, which are usually not expected to be handled explicitly by the caller.

 2. Extending Exception
     If your custom exception class extends Exception, it becomes a checked exception.
     Checked exceptions need to be explicitly declared in the throws clause of any method that can throw
     them, and they must be handled (either caught or rethrown) by the caller.
*/

}
