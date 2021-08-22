package com.pizza.services;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.pizza.dao.PizzaRepository;
import com.pizza.model.Pizza;
import com.pizza.model.PizzaImage;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository dao;

    @Autowired
    private GridFsTemplate template;

    @Autowired
    private GridFsOperations operations;


    public String addFileService(MultipartFile file) throws IOException{

        DBObject metadata = new BasicDBObject();

        Object fileID = template.store(
                                file.getInputStream(),
                                file.getOriginalFilename(),
                                file.getContentType(), metadata);

        return fileID.toString();
    }

    public PizzaImage downloadFile(String id) throws IOException {

        GridFSFile gridFSFile = template.findOne( new Query(Criteria.where("_id").is(id)) );

        PizzaImage pizzaImage = new PizzaImage();

        if (gridFSFile != null && gridFSFile.getMetadata() != null) {
            pizzaImage.setFilename( gridFSFile.getFilename() );

            pizzaImage.setFileType( gridFSFile.getMetadata().get("_contentType").toString() );

            pizzaImage.setFileSize( gridFSFile.getMetadata().get("fileSize").toString() );

            pizzaImage.setFile( IOUtils.toByteArray(operations.getResource(gridFSFile).getInputStream()) );
        }

        return pizzaImage;
    }


    public List<Pizza> fetchAllPizzaService(){
        return dao.findAll();
    }

    public Pizza findByIdService(int id) {
        return dao.findById(id)
                  .orElseThrow( () -> new RuntimeException("No Data Found"+id));
    }
}
