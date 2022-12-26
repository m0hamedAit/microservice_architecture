package ma.m0hamedait

import java.util.*

data class CreateCustomerRequestDTO(
    var name: String,
    var email: String,
    var phone: String,
    var address: String
)

data class UpdateCustomerRequestDTO(
    var id: String,
    var name: String,
    var email: String,
    var phone: String,
    var address: String
)

// Category
data class CreateCategoryRequestDTO(
    var name: String,
    var description: String
)

data class UpdateCategoryRequestDTO(
    var id: String,
    var name: String,
    var description: String
)

// Product
data class CreateProductRequestDTO(
    var name: String,
    var price: Double,
    var quantity: Int,
    var status: ProductStatus,
    var categoryId: String
)

data class UpdateProductRequestDTO(
    var id: String,
    var name: String,
    var price: Double,
    var quantity: Int,
    var status: ProductStatus,
    var categoryId: String
)

data class UpdateProductQuantityRequestDTO(
    var id: String,
    var quantity: Int
)

data class UpdateProductStatusRequestDTO(
    var id: String,
    var status: ProductStatus
)

//Order
data class CreateOrderRequestDTO(
    val dateDelivery: Date,
    val address: String,
    val orderStatus: OrderStatus,
    var customerId: String,
)

data class UpdateOrderRequestDTO(
    var id: String,
    var dateOrder: Date,
    val dateDelivery: Date,
    val address: String,
    val orderStatus: OrderStatus,
    var customerId: String,
)

data class UpdateOrderStatusRequestDTO(
    var id: String,
    var orderStatus: OrderStatus
)

data class DeleteOrderRequestDTO(
    var id: String
)

// orderItem
data class CreateOrderItemRequestDTO(
    var quantity: Int,
    var unitPrice: Double,
    var solde: Int,
    var orderId: String,
    var productId: String,
)

data class UpdateOrderItemRequestDTO(
    var id: String,
    var quantity: Int,
    var unitPrice: Double,
    var solde: Int,
    var orderId: String,
    var productId: String,
)

data class UpdateOrderItemQuantityRequestDTO(
    var id: String,
    var quantity: Int
)

data class DeleteOrderItemRequestDTO(
    var id: String
)

