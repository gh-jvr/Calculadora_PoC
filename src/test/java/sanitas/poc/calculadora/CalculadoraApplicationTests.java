package sanitas.poc.calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.JUnitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Clase de test unitarios de la API.
 */
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class CalculadoraApplicationTests {

    /**
     * Constante para el endPoint de sumar.
     */
    private static final String END_POINT_SUMAR = "/sumar";

    /**
     * Constante para el endPoint de restar.
     */
    private static final String END_POINT_RESTAR = "/restar";

    /**
     * Instancia de la clase encargada de mockear las llamadas a la API.
     */
    @Autowired
    protected MockMvc mvc;

    /**
     * Test simple para probar que la API realiza los cálculos correctamente.
     * @throws JUnitException en caso de cualquier error.
     */
    @Test
    public void checkOk() throws JUnitException {
        MvcResult mvcResult;
        try {
            mvcResult = mvc.perform(
                            MockMvcRequestBuilders.post(END_POINT_SUMAR).
                                    contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                                    .param("a", "3")
                                    .param("b", "2")
                    )
                    .andReturn();

            MockHttpServletResponse response = mvcResult.getResponse();
            int status = response.getStatus();

            Assertions.assertEquals(200, status);
            Assertions.assertTrue(response.getContentAsString().contains("\"resultado\":5"));

            mvcResult = mvc.perform(
                            MockMvcRequestBuilders.post(END_POINT_RESTAR).
                                    contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                                    .param("a", "3")
                                    .param("b", "2")
                    )
                    .andReturn();

            response = mvcResult.getResponse();
            status = response.getStatus();

            Assertions.assertEquals(200, status);
            Assertions.assertTrue(response.getContentAsString().contains("\"resultado\":1"));

        } catch (Exception e) {
            throw new JUnitException(e.getMessage(), e);
        }
    }

    /**
     * Comprueba que la suma y resta con decimales se realiza correctamente.
     * @throws JUnitException en caso de cualquier error.
     */
    @Test
    public void checkOkDecimals() throws JUnitException {
        MvcResult mvcResult;
        try {
            mvcResult = mvc.perform(
                            MockMvcRequestBuilders.post(END_POINT_SUMAR).
                                    contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                                    .param("a", "3,02")
                                    .param("b", "2.45")
                    )
                    .andReturn();

            MockHttpServletResponse response = mvcResult.getResponse();
            int status = response.getStatus();

            Assertions.assertEquals(200, status);
            Assertions.assertTrue(response.getContentAsString().contains("\"resultado\":5.47"));

            mvcResult = mvc.perform(
                            MockMvcRequestBuilders.post(END_POINT_RESTAR).
                                    contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                                    .param("a", "3.74")
                                    .param("b", "2.33")
                    )
                    .andReturn();

            response = mvcResult.getResponse();
            status = response.getStatus();

            Assertions.assertEquals(200, status);
            Assertions.assertTrue(response.getContentAsString().contains("\"resultado\":1.41"));

        } catch (Exception e) {
            throw new JUnitException(e.getMessage(), e);
        }
    }

    /**
     * Comprueba que las operaciones con números negativos se realizan correctamente.
     * @throws JUnitException en caso de cualquier error.
     */
    @Test
    public void checkOkNegatives() throws JUnitException {
        MvcResult mvcResult;
        try {
            mvcResult = mvc.perform(
                            MockMvcRequestBuilders.post(END_POINT_SUMAR).
                                    contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                                    .param("a", "10")
                                    .param("b", "-12")
                    )
                    .andReturn();

            MockHttpServletResponse response = mvcResult.getResponse();
            int status = response.getStatus();

            Assertions.assertEquals(200, status);
            Assertions.assertTrue(response.getContentAsString().contains("\"resultado\":-2"));

            mvcResult = mvc.perform(
                            MockMvcRequestBuilders.post(END_POINT_RESTAR).
                                    contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                                    .param("a", "14")
                                    .param("b", "-6")
                    )
                    .andReturn();

            response = mvcResult.getResponse();
            status = response.getStatus();

            Assertions.assertEquals(200, status);
            Assertions.assertTrue(response.getContentAsString().contains("\"resultado\":20"));

        } catch (Exception e) {
            throw new JUnitException(e.getMessage(), e);
        }
    }

    /**
     * Comprueba que la aplicación se comporta correctamente cuando el número de parámetros es incorrecto.
     * @throws JUnitException en caso de cualquier error.
     */
    @Test
    public void checkInvalidNumberOfParams() throws JUnitException {
        MvcResult mvcResult;
        try {
            mvcResult = mvc.perform(
                            MockMvcRequestBuilders.post(END_POINT_SUMAR).
                                    contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                                    .param("b", "2")
                    )
                    .andReturn();

            MockHttpServletResponse response = mvcResult.getResponse();
            int status = response.getStatus();

            Assertions.assertEquals(400, status);
            Assertions.assertTrue(response.getContentAsString().contains("\"errorCode\":0"));

        } catch (Exception e) {
            throw new JUnitException(e.getMessage(), e);
        }
    }

    /**
     * Comprueba que la aplicación se comporta de forma correcta cuando algunos de los parámetros de entrada
     * está vacío.
     * @throws JUnitException en caso de cualquier error.
     */
    @Test
    public void checkEmptyInput() throws JUnitException {
        MvcResult mvcResult;
        try {
            mvcResult = mvc.perform(
                            MockMvcRequestBuilders.post(END_POINT_SUMAR).
                                    contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                                    .param("a", "")
                                    .param("b", "2")
                    )
                    .andReturn();

            MockHttpServletResponse response = mvcResult.getResponse();
            int status = response.getStatus();

            Assertions.assertEquals(400, status);
            Assertions.assertTrue(response.getContentAsString().contains("\"errorCode\":2"));

        } catch (Exception e) {
            throw new JUnitException(e.getMessage(), e);
        }
    }

    /**
     * Comprueba que la aplicación se comporta de forma correcta cuando algunos de los parámetros de entrada
     * tiene un valor incorrecto.
     * @throws JUnitException
     */
    @Test
    public void checkInvalidInput() throws JUnitException {
        MvcResult mvcResult;
        try {
            mvcResult = mvc.perform(
                            MockMvcRequestBuilders.post(END_POINT_SUMAR).
                                    contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                                    .param("a", "InvalidParam")
                                    .param("b", "2")
                    )
                    .andReturn();

            MockHttpServletResponse response = mvcResult.getResponse();
            int status = response.getStatus();

            Assertions.assertEquals(400, status);
            Assertions.assertTrue(response.getContentAsString().contains("\"errorCode\":3"));

        } catch (Exception e) {
            throw new JUnitException(e.getMessage(), e);
        }
    }

}
