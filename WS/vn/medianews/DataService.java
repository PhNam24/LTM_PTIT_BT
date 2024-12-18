
package WS.vn.medianews;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "DataService", targetNamespace = "http://medianews.vn/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DataService {


    /**
     * 
     * @param studentCode
     * @param qCode
     * @return
     *     returns java.util.List<java.lang.Integer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getData", targetNamespace = "http://medianews.vn/", className = "WS.vn.medianews.GetData")
    @ResponseWrapper(localName = "getDataResponse", targetNamespace = "http://medianews.vn/", className = "WS.vn.medianews.GetDataResponse")
    @Action(input = "http://medianews.vn/DataService/getDataRequest", output = "http://medianews.vn/DataService/getDataResponse")
    public List<Integer> getData(
        @WebParam(name = "studentCode", targetNamespace = "")
        String studentCode,
        @WebParam(name = "qCode", targetNamespace = "")
        String qCode);

    /**
     * 
     * @param data
     * @param studentCode
     * @param qCode
     */
    @WebMethod
    @RequestWrapper(localName = "submitDataInt", targetNamespace = "http://medianews.vn/", className = "WS.vn.medianews.SubmitDataInt")
    @ResponseWrapper(localName = "submitDataIntResponse", targetNamespace = "http://medianews.vn/", className = "WS.vn.medianews.SubmitDataIntResponse")
    @Action(input = "http://medianews.vn/DataService/submitDataIntRequest", output = "http://medianews.vn/DataService/submitDataIntResponse")
    public void submitDataInt(
        @WebParam(name = "studentCode", targetNamespace = "")
        String studentCode,
        @WebParam(name = "qCode", targetNamespace = "")
        String qCode,
        @WebParam(name = "data", targetNamespace = "")
        int data);

    /**
     * 
     * @param studentCode
     * @param qCode
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDataDouble", targetNamespace = "http://medianews.vn/", className = "WS.vn.medianews.GetDataDouble")
    @ResponseWrapper(localName = "getDataDoubleResponse", targetNamespace = "http://medianews.vn/", className = "WS.vn.medianews.GetDataDoubleResponse")
    @Action(input = "http://medianews.vn/DataService/getDataDoubleRequest", output = "http://medianews.vn/DataService/getDataDoubleResponse")
    public double getDataDouble(
        @WebParam(name = "studentCode", targetNamespace = "")
        String studentCode,
        @WebParam(name = "qCode", targetNamespace = "")
        String qCode);

    /**
     * 
     * @param data
     * @param studentCode
     * @param qCode
     */
    @WebMethod
    @RequestWrapper(localName = "submitDataString", targetNamespace = "http://medianews.vn/", className = "WS.vn.medianews.SubmitDataString")
    @ResponseWrapper(localName = "submitDataStringResponse", targetNamespace = "http://medianews.vn/", className = "WS.vn.medianews.SubmitDataStringResponse")
    @Action(input = "http://medianews.vn/DataService/submitDataStringRequest", output = "http://medianews.vn/DataService/submitDataStringResponse")
    public void submitDataString(
        @WebParam(name = "studentCode", targetNamespace = "")
        String studentCode,
        @WebParam(name = "qCode", targetNamespace = "")
        String qCode,
        @WebParam(name = "data", targetNamespace = "")
        String data);

    /**
     * 
     * @param data
     * @param studentCode
     * @param qCode
     */
    @WebMethod
    @RequestWrapper(localName = "submitDataIntArray", targetNamespace = "http://medianews.vn/", className = "WS.vn.medianews.SubmitDataIntArray")
    @ResponseWrapper(localName = "submitDataIntArrayResponse", targetNamespace = "http://medianews.vn/", className = "WS.vn.medianews.SubmitDataIntArrayResponse")
    @Action(input = "http://medianews.vn/DataService/submitDataIntArrayRequest", output = "http://medianews.vn/DataService/submitDataIntArrayResponse")
    public void submitDataIntArray(
        @WebParam(name = "studentCode", targetNamespace = "")
        String studentCode,
        @WebParam(name = "qCode", targetNamespace = "")
        String qCode,
        @WebParam(name = "data", targetNamespace = "")
        List<Integer> data);

    /**
     * 
     * @param data
     * @param studentCode
     * @param qCode
     */
    @WebMethod
    @RequestWrapper(localName = "submitDataStringArray", targetNamespace = "http://medianews.vn/", className = "WS.vn.medianews.SubmitDataStringArray")
    @ResponseWrapper(localName = "submitDataStringArrayResponse", targetNamespace = "http://medianews.vn/", className = "WS.vn.medianews.SubmitDataStringArrayResponse")
    @Action(input = "http://medianews.vn/DataService/submitDataStringArrayRequest", output = "http://medianews.vn/DataService/submitDataStringArrayResponse")
    public void submitDataStringArray(
        @WebParam(name = "studentCode", targetNamespace = "")
        String studentCode,
        @WebParam(name = "qCode", targetNamespace = "")
        String qCode,
        @WebParam(name = "data", targetNamespace = "")
        List<String> data);

}
