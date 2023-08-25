<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <title>Challan Form</title>
</head>
<body>

<div class="container mt-5">
  <h2 class="mb-4">Challan Form</h2>
  <form action="ChallanServlet" method="post">
  <input type="hidden" name="username" value="<%= request.getParameter("username") %>">
    <div class="form-row">
      <div class="form-group col-md-6">
        <label for="from">From</label>
        <input type="text" class="form-control" id="from" name="from" required>
      </div>
      <div class="form-group col-md-6">
        <label for="to">To</label>
        <input type="text" class="form-control" id="to" name="to" required>
      </div>
    </div>
   
    <div class="form-row">
      <div class="form-group col-md-4">
        <label for="quantity">Quantity</label>
        <input type="number" class="form-control" id="quantity" name="quantity" required>
      </div>
      <div class="form-group col-md-4">
        <label for="productDetails">Product Details</label>
        <input type="text" class="form-control" id="productDetails" name="productDetails" required>
      </div>
      <div class="form-group col-md-4">
        <label for="rate">Rate</label>
        <input type="number" class="form-control" id="rate" name="rate" required>
      </div>
    </div>
    <div class="form-group">
      <label for="finalAmount">Final Amount</label>
      <input type="number" class="form-control" id="finalAmount" name="finalAmount" required>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>

</body>
</html>
