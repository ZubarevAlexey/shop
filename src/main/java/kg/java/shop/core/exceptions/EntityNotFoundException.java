package kg.java.shop.core.exceptions;

public class EntityNotFoundException extends Exception
{
    public EntityNotFoundException() {
        super("entity not found");
    }
}
