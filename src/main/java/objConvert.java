import java.text.DecimalFormat;

public class objConvert
{

    //The String arrays store all the supported conversions. If you add/remove items in the array make sure you
    //change the double arrays with the conversions, as the programme uses the String array indexes to corrospond
    //with the double array indexes.
    private final String[] strDistanceMenu = {"Millimetre","Centimetre","Metre","Kilometre","Inch","Foot","Yard","Mile"};
    private final String[] strWeightMenu = {"Milligram","Gram","Kilogram","Ounce","Pound","Stone"};
    private final String[] strVolumeMenu = {"Millilitre","Centilitre","Litre","Fluid Ounce","Pint","Gallon"};
    private final String[] strTemperatureMenu = {"Centigrade","Fahrenheit"};

    //These string arrays store the symbols to be used with the answers. Keep them in the same order as the menu String arrays
    private final String[] strDistanceSymbol = {"mm","cm","m","km","in","ft","yd","m"};
    private final String[] strWeightSymbol = {"mg","g","kg","oz","lb","st"};
    private final String[] strVolumeSymbol = {"ml","cl","l","Foz","p","g"};
    private final String[] strTemperatureSymbol = {"*C","*F"};

    //Conversion tables, make sure you keep them in the same order as the labels in the String arrays
    //They are named as <type><unit> e.g. distanceMM means you are converting FROM Millimetres into....

    //Distance table
    private final double[] distanceMM = {1.0, 0.1, 0.001, 0.000001, 0.03937, 0.003281, 0.001094, 0.00000062};
    private final double[] distanceCM = {10.0, 1.0, 0.01, 0.00001, 0.3937, 0.0328, 0.01093, 0.0000062};
    private final double[] distanceM = {1000.0, 100.0, 1.0, 0.001, 39.37, 3.28, 1.093, 0.00062};
    private final double[] distanceKM = {1000000.0, 100000.0, 1000.0, 1.0, 39370.0, 3280.0, 1093.0, 0.6213};
    private final double[] distanceInch = {25.4, 2.54, 0.0254, 0.0000254, 1.0, 0.083, 0.027, 0.0000157};
    private final double[] distanceFoot = {304.8, 30.48, 0.3048, 0.0003048, 12.0, 1.0, 0.33, 0.000189};
    private final double[] distanceYard = {914.4, 91.44, 0.9144, 0.0009144, 36.0, 3.0, 1.0, 0.000568};
    private final double[] distanceMile = {1609344.0, 160934.4, 1609.344, 1.609344, 63360.0, 5280.0, 1760.0, 1.0};
    private final double[][] distanceTable = {distanceMM, distanceCM, distanceM, distanceKM, distanceInch, distanceFoot, distanceYard, distanceMile};

    //Weight table
    private final double[] weightMG = {1.0, 0.001, 0.000001, 0.00003527, 0.000002205, 0.0000001575};
    private final double[] weightG = {1000.0, 1.0, 0.001, 0.03527, 0.002205, 0.0001575};
    private final double[] weightKG = {1000000.0, 1000.0, 1.0, 35.27, 2.205, 0.1575};
    private final double[] weightOunce = {28350.0, 28.35, 0.02835, 1.0, 0.0625, 0.004464};
    private final double[] weightPound = {453600.0, 453.6, 0.4536, 16.0, 1.0, 0.07143};
    private final double[] weightStone = {6350000.0, 6350.0, 6.35, 224.0, 14.0, 1.0};
    private final double[][] weightTable = {weightMG, weightG, weightKG, weightOunce, weightPound, weightStone};

    //Volume table
    private final double[] volumeML = {1.0, 0.1, 0.001, 0.03381, 0.002113, 0.0003642};
    private final double[] volumeCL = {10.0, 1.0, 0.01, 0.3381, 0.02113, 0.002642};
    private final double[] volumeLitre = {1000.0, 100.0, 1.0, 33.81, 2.113, 0.2642};
    private final double[] volumeOunce = {29.57, 2.957, 0.02957, 1.0, 0.0625, 0.007813};
    private final double[] volumePint = {473.2, 47.32, 0.4732, 16.0, 1.0, 0.125};
    private final double[] volumeGallon = {3785.0, 378.5, 3.785, 128, 8, 1.0};
    private final double[][] volumeTable = {volumeML, volumeCL, volumeLitre, volumeOunce, volumePint, volumeGallon};

    private final DecimalFormat decFormat = new DecimalFormat("#,###.##");

    public objConvert()
    {
    }

    public String convertDistance(int sourceIndex, int desIndex, double unit)
    {
        //Sends the cell reference of the 2D array to the convert method (same for distance, weight and volume)
        //Adds the symbol to the end of the answer
        return "" + convert(distanceTable[sourceIndex][desIndex], unit) + strDistanceSymbol[desIndex];
    }

    public String convertWeight(int sourceIndex, int desIndex, double unit)
    {
        return "" + convert(weightTable[sourceIndex][desIndex], unit) + strWeightSymbol[desIndex];
    }

    public String convertVolume(int sourceIndex, int desIndex, double unit)
    {
        return "" + convert(volumeTable[sourceIndex][desIndex], unit) + strVolumeSymbol[desIndex];
    }

    public String convertTemperature(int sourceIndex, int desIndex, double unit)
    {

        double answer = 0.0;

        if (sourceIndex == desIndex)
        {
            answer = unit;
        }
        else if (sourceIndex == 0)
        {
            answer = unit * 9/5 + 32;
        }
        else
        {
            answer = (unit - 32) * 5/9;
        }

        return "Answer: " + decFormat.format(answer) + strTemperatureSymbol[desIndex];

    }

    private String convert(double conversionRate, double unit)
    {
        return "Answer: " + decFormat.format(conversionRate * unit);
    }

    public String[] getDistanceMenu()
    {
        return strDistanceMenu;
    }

    public String[] getWeightMenu()
    {
        return strWeightMenu;
    }

    public String[] getVolumeMenu()
    {
        return strVolumeMenu;
    }

    public String[] getTemperatureMenu()
    {
        return strTemperatureMenu;
    }

}