
<!doctype html>
<html lang="en-US">
<head>
  <meta charset="utf-8">
  <title>Convert</title>

  <script>
    function showResult(result){
      document.getElementById("result").value = result;
    }
  </script>

</head>
<body>
    <form method="post">
      Amount : <input type="text" name="amount" id="amount" placeholder="Enter amount" required> € <br><br>
      <input type="submit" name="convert" style="margin-left:100px;" value="Convert" onclick="Convert()">
    </form><br>
    
    Result : <input type="text" name="result" id="result" value="" />  Dh

</body>
</html>



<?php
  
  $client = new SoapClient("http://localhost:9191/BankWS?wsdl");
  if(array_key_exists('convert', $_POST)){
    Convert();
  }
  
  function Convert() {
    global $client, $result, $amount;
    $result = $client ->__soapCall("Convert", array("parameters" => array("amount" => $_POST['amount'])));
    $result = $result->return;
    echo '<script>showResult('.$result.');</script>';
  }

?> 



