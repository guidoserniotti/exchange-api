public class Helper {
    public void showApiReqExample(){
        System.out.println("""
                Consulta: 
                '¿A cuánto equivale un dolar en pesos argentinos?'
                https://v6.exchangerate-api.com/v6/YOUR_API_KEY/pair/usd/arg
                
                Salida: 
                    {
                        "result": "success",
                            . . .
                        "base_code": "USD",
                        "target_code": "ARS",
                        "conversion_rate": 1438.58
                    }
                'Un dolar equivale a 1438.58 pesos argentinos.'
                """);
    }
}
