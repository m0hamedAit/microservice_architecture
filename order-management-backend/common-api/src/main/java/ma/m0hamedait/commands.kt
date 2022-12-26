package ma.m0hamedait

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*

abstract class BaseCommand<T>(
    @TargetAggregateIdentifier open val id: T
);

// Customer
data class CreateCustomerCommand(
    override val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val address: String
) : BaseCommand<String>(id);

data class UpdateCustomerCommand(
    override val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val address: String
) : BaseCommand<String>(id);

data class DeleteCustomerCommand(
    override val id: String
) : BaseCommand<String>(id);

// Category
data class CreateCategoryCommand(
    override val id: String,
    val name: String,
    val description: String
) : BaseCommand<String>(id);

data class UpdateCategoryCommand(
    override val id: String,
    val name: String,
    val description: String
) : BaseCommand<String>(id);

data class DeleteCategoryCommand(
    override val id: String
) : BaseCommand<String>(id);

//Product
data class CreateProductCommand(
    override val id: String,
    val name: String,
    val price: Double,
    val quantity: Int,
    val status: ProductStatus,
    val categoryId: String
) : BaseCommand<String>(id);

data class UpdateProductCommand(
    override val id: String,
    val name: String,
    val price: Double,
    val quantity: Int,
    val status: ProductStatus,
    val categoryId: String
) : BaseCommand<String>(id);

data class DeleteProductCommand(
    override val id: String
) : BaseCommand<String>(id);

data class UpdateProductStatusCommand(
    override val id: String,
    val status: ProductStatus
) : BaseCommand<String>(id);

data class UpdateProductQuantityCommand(
    override val id: String,
    val quantity: Int
) : BaseCommand<String>(id);

// Order
data class CreateOrderCommand(
    override val id: String,
    val dateOrder: Date,
    val dateDelivery: Date,
    val address: String,
    val orderStatus: OrderStatus,
    val customerId: String,
) : BaseCommand<String>(id);

data class UpdateOrderCommand(
    override val id: String,
    val dateOrder: Date,
    val dateDelivery: Date,
    val address: String,
    val orderStatus: OrderStatus,
    val customerId: String,
) : BaseCommand<String>(id);

data class DeleteOrderCommand(
    override val id: String
) : BaseCommand<String>(id);

data class UpdateOrderStatusCommand(
    override val id: String,
    val orderStatus: OrderStatus
) : BaseCommand<String>(id);

//  OrderItem
data class CreateOrderItemCommand(
    override val id: String,
    val quantity: Int,
    val unitPrice: Double,
    val solde: Int,
    val orderId: String,
    val productId: String
) : BaseCommand<String>(id);

data class UpdateOrderItemCommand(
    override val id: String,
    val quantity: Int,
    val unitPrice: Double,
    val solde: Int,
    val orderId: String,
    val productId: String
) : BaseCommand<String>(id);

data class DeleteOrderItemCommand(
    override val id: String
) : BaseCommand<String>(id);

data class UpdateOrderItemQuantityCommand(
    override val id: String,
    val quantity: Int
) : BaseCommand<String>(id);