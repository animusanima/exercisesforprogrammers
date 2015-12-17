package data;

/**
 *
 * @author animusanima
 */
public final class Quote 
{
    private final String quotation;
    private final String author;
    
    public Quote(String quotation, String author) {
        this.quotation = quotation;
        this.author = author;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public String getQuotation()
    {
        return quotation;
    }
}