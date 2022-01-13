package com.SushiEmperor.SushiEmperor;

import com.SushiEmperor.SushiEmperor.model.Cart;
import com.SushiEmperor.SushiEmperor.model.Product;
import com.SushiEmperor.SushiEmperor.model.Users;
import com.SushiEmperor.SushiEmperor.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CartTests {
    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testAddOneCart () {
        Product product = entityManager.find(Product.class, 2);
        Users user = entityManager.find(Users.class, 1);
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setProduct(product);
        cart.setQuantity(2);

        Cart savedCartItem = cartRepo.save(cart);
        assertTrue(savedCartItem.getId() > 0);
    }


}
