package product.rest.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import product.rest.api.integration.CustomObjectDAO;
import product.rest.api.integration.CustomObjectEntity;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
public class ProductController {

    @Autowired
    private CustomObjectDAO customObjectDAO;

    @RequestMapping("/product/{id}")
    public String index(@PathVariable int id) {
        CustomObjectEntity byID = customObjectDAO.getByID(id);
        return byID.getFirstname();

    }

}