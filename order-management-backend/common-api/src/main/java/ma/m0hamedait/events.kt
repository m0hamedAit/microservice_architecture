package ma.m0hamedait

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*

abstract class BaseEvent<T>(
    @TargetAggregateIdentifier open val id: T
);

data class CustomerCreatedEvent(
    override var id: String,
    var name: String,
    var email: String,
    var phone: String,
    var address: String
) : BaseEvent<String>(id);

data class CustomerUpdatedEvent(
    override var id: String,
    var name: String,
    var email: String,
    var phone: String,
    var address: String
) : BaseEvent<String>(id);

data class CustomerDeletedEvent(
    override var id: String
) : BaseEvent<String>(id);

// Product
data class ProductCreatedEvent(
    override var id: String,
    var name: String,
    var price: Double,
    var quantity: Int,
    var status: ProductStatus,
    var categoryId: String
) : BaseEvent<String>(id);

data class ProductUpdatedEvent(
    override var id: String,
    var name: String,
    var price: Double,
    var quantity: Int,
    var status: ProductStatus,
    var categoryId: String
) : BaseEvent<String>(id);

data class ProductDeletedEvent(
    override var id: String
) : BaseEvent<String>(id);

data class ProductQuantityUpdatedEvent(
    override var id: String,
    var quantity: Int
) : BaseEvent<String>(id);

data class ProductStatusUpdatedEvent(
    override var id: String,
    var status: ProductStatus
) : BaseEvent<String>(id);

// category

data class CategoryCreatedEvent(
    override var id: String,
    var name: String,
    var description: String
) : BaseEvent<String>(id);

data class CategoryUpdatedEvent(
    override var id: String,
    var name: String,
    var description: String
) : BaseEvent<String>(id);

data class CategoryDeletedEvent(
    override var id: String
) : BaseEvent<String>(id);


// Order
data class OrderCreatedEvent(
    override var id: String,
    var dateOrder: Date,
    val dateDelivery: Date,
    val address: String,
    val orderStatus: OrderStatus,
    var customerId: String,
) : BaseEvent<String>(id);

data class OrderUpdatedEvent(
    override var id: String,
    var dateOrder: Date,
    val dateDelivery: Date,
    val address: String,
    val orderStatus: OrderStatus,
    var customerId: String,
) : BaseEvent<String>(id);

data class OrderStatusUpdatedEvent(
    override var id: String,
    val orderStatus: OrderStatus
) : BaseEvent<String>(id);

data class OrderDeletedEvent(
    override var id: String
) : BaseEvent<String>(id);

// OrderItem
data class OrderItemCreatedEvent(
    override var id: String,
    var quantity: Int,
    var unitPrice: Double,
    var solde: Int,
    var orderId: String,
    var productId: String

) : BaseEvent<String>(id);

data class OrderItemUpdatedEvent(
    override var id: String,
    var quantity: Int,
    var unitPrice: Double,
    var solde: Int,
    var orderId: String,
    var productId: String
) : BaseEvent<String>(id);

data class OrderItemQuantityUpdatedEvent(
    override var id: String,
    var quantity: Int
) : BaseEvent<String>(id);

data class OrderItemDeletedEvent(
    override var id: String
) : BaseEvent<String>(id);