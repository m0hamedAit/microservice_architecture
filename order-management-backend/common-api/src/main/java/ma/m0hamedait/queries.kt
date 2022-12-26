package ma.m0hamedait

// customer
class GetAllCustomersQuery();

data class GetCustomerByIdQuery(
    val id:String,
);

// categories
class GetAllCategoriesQuery();

data class GetCategoryByIdQuery(
    val id:String,
);

// products
class GetAllProductsQuery();

data class GetProductByIdQuery(
    val id:String,
);

data class GetProductsByCategoryQuery(
    val categoryId:String,
);

//Order
class GetAllOrdersQuery();

data class GetOrderByIdQuery(
    val id:String,
);

data class GetOrdersByCustomerQuery(
    val customerId:String,
);

data class GetOrdersByProductQuery(
    val productId:String,
);

// OrderItem
data class GetOrderItemsByOrderQuery(
    val orderId:String,
);
