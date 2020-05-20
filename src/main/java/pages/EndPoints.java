package pages;

public class EndPoints {

    public static String randomAmountEndPoint(String animalType, String amount)
    {
        String getAmountRandomEndPoint = "facts/random?animal_type="+animalType+"&amount="+amount+"";
        return getAmountRandomEndPoint;
    }
}
