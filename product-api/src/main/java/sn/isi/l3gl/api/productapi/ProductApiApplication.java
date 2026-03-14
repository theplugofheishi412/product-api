package sn.isi.l3gl.api.productapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "sn.isi.l3gl.api.productapi",
        "sn.isi.l3gl.core.product_core"
})
@EnableJpaRepositories(basePackages = "sn.isi.l3gl.core.product_core.repository")
public class ProductApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApiApplication.class, args);
    }
}