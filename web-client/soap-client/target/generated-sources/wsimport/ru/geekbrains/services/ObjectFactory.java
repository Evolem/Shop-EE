
package ru.geekbrains.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.geekbrains.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UpdateResponse_QNAME = new QName("http://services.geekbrains.ru/", "updateResponse");
    private final static QName _FindAllResponse_QNAME = new QName("http://services.geekbrains.ru/", "findAllResponse");
    private final static QName _FindById_QNAME = new QName("http://services.geekbrains.ru/", "findById");
    private final static QName _FindByIdResponse_QNAME = new QName("http://services.geekbrains.ru/", "findByIdResponse");
    private final static QName _DeleteResponse_QNAME = new QName("http://services.geekbrains.ru/", "deleteResponse");
    private final static QName _FindAllByCategoryIdResponse_QNAME = new QName("http://services.geekbrains.ru/", "findAllByCategoryIdResponse");
    private final static QName _InsertProductResponse_QNAME = new QName("http://services.geekbrains.ru/", "insertProductResponse");
    private final static QName _Delete_QNAME = new QName("http://services.geekbrains.ru/", "delete");
    private final static QName _FindAll_QNAME = new QName("http://services.geekbrains.ru/", "findAll");
    private final static QName _FindProductByName_QNAME = new QName("http://services.geekbrains.ru/", "findProductByName");
    private final static QName _Update_QNAME = new QName("http://services.geekbrains.ru/", "update");
    private final static QName _InsertProduct_QNAME = new QName("http://services.geekbrains.ru/", "insertProduct");
    private final static QName _FindAllByCategoryId_QNAME = new QName("http://services.geekbrains.ru/", "findAllByCategoryId");
    private final static QName _FindProductByNameResponse_QNAME = new QName("http://services.geekbrains.ru/", "findProductByNameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.geekbrains.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindProductByNameResponse }
     * 
     */
    public FindProductByNameResponse createFindProductByNameResponse() {
        return new FindProductByNameResponse();
    }

    /**
     * Create an instance of {@link FindAllByCategoryId }
     * 
     */
    public FindAllByCategoryId createFindAllByCategoryId() {
        return new FindAllByCategoryId();
    }

    /**
     * Create an instance of {@link InsertProduct }
     * 
     */
    public InsertProduct createInsertProduct() {
        return new InsertProduct();
    }

    /**
     * Create an instance of {@link FindProductByName }
     * 
     */
    public FindProductByName createFindProductByName() {
        return new FindProductByName();
    }

    /**
     * Create an instance of {@link Update }
     * 
     */
    public Update createUpdate() {
        return new Update();
    }

    /**
     * Create an instance of {@link Delete }
     * 
     */
    public Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link FindAllByCategoryIdResponse }
     * 
     */
    public FindAllByCategoryIdResponse createFindAllByCategoryIdResponse() {
        return new FindAllByCategoryIdResponse();
    }

    /**
     * Create an instance of {@link InsertProductResponse }
     * 
     */
    public InsertProductResponse createInsertProductResponse() {
        return new InsertProductResponse();
    }

    /**
     * Create an instance of {@link DeleteResponse }
     * 
     */
    public DeleteResponse createDeleteResponse() {
        return new DeleteResponse();
    }

    /**
     * Create an instance of {@link FindById }
     * 
     */
    public FindById createFindById() {
        return new FindById();
    }

    /**
     * Create an instance of {@link FindByIdResponse }
     * 
     */
    public FindByIdResponse createFindByIdResponse() {
        return new FindByIdResponse();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link UpdateResponse }
     * 
     */
    public UpdateResponse createUpdateResponse() {
        return new UpdateResponse();
    }

    /**
     * Create an instance of {@link ProductPojo }
     * 
     */
    public ProductPojo createProductPojo() {
        return new ProductPojo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.geekbrains.ru/", name = "updateResponse")
    public JAXBElement<UpdateResponse> createUpdateResponse(UpdateResponse value) {
        return new JAXBElement<UpdateResponse>(_UpdateResponse_QNAME, UpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.geekbrains.ru/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.geekbrains.ru/", name = "findById")
    public JAXBElement<FindById> createFindById(FindById value) {
        return new JAXBElement<FindById>(_FindById_QNAME, FindById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.geekbrains.ru/", name = "findByIdResponse")
    public JAXBElement<FindByIdResponse> createFindByIdResponse(FindByIdResponse value) {
        return new JAXBElement<FindByIdResponse>(_FindByIdResponse_QNAME, FindByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.geekbrains.ru/", name = "deleteResponse")
    public JAXBElement<DeleteResponse> createDeleteResponse(DeleteResponse value) {
        return new JAXBElement<DeleteResponse>(_DeleteResponse_QNAME, DeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllByCategoryIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.geekbrains.ru/", name = "findAllByCategoryIdResponse")
    public JAXBElement<FindAllByCategoryIdResponse> createFindAllByCategoryIdResponse(FindAllByCategoryIdResponse value) {
        return new JAXBElement<FindAllByCategoryIdResponse>(_FindAllByCategoryIdResponse_QNAME, FindAllByCategoryIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.geekbrains.ru/", name = "insertProductResponse")
    public JAXBElement<InsertProductResponse> createInsertProductResponse(InsertProductResponse value) {
        return new JAXBElement<InsertProductResponse>(_InsertProductResponse_QNAME, InsertProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.geekbrains.ru/", name = "delete")
    public JAXBElement<Delete> createDelete(Delete value) {
        return new JAXBElement<Delete>(_Delete_QNAME, Delete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.geekbrains.ru/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindProductByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.geekbrains.ru/", name = "findProductByName")
    public JAXBElement<FindProductByName> createFindProductByName(FindProductByName value) {
        return new JAXBElement<FindProductByName>(_FindProductByName_QNAME, FindProductByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Update }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.geekbrains.ru/", name = "update")
    public JAXBElement<Update> createUpdate(Update value) {
        return new JAXBElement<Update>(_Update_QNAME, Update.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.geekbrains.ru/", name = "insertProduct")
    public JAXBElement<InsertProduct> createInsertProduct(InsertProduct value) {
        return new JAXBElement<InsertProduct>(_InsertProduct_QNAME, InsertProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllByCategoryId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.geekbrains.ru/", name = "findAllByCategoryId")
    public JAXBElement<FindAllByCategoryId> createFindAllByCategoryId(FindAllByCategoryId value) {
        return new JAXBElement<FindAllByCategoryId>(_FindAllByCategoryId_QNAME, FindAllByCategoryId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindProductByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.geekbrains.ru/", name = "findProductByNameResponse")
    public JAXBElement<FindProductByNameResponse> createFindProductByNameResponse(FindProductByNameResponse value) {
        return new JAXBElement<FindProductByNameResponse>(_FindProductByNameResponse_QNAME, FindProductByNameResponse.class, null, value);
    }

}
