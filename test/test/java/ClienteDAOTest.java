package test.java;

import main.java.Cliente;
import main.java.dao.ClienteDAO;
import main.java.dao.IClienteDAO;
import main.java.exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.java.dao.ClienteDAOMock;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;
    private Cliente cliente;

    public ClienteDAOTest() {
      clienteDao = new ClienteDAOMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(12345654380L);
        cliente.setNome("rodney");
        cliente.setCidade("São Paulo");
        cliente.setEnd("Maracanã");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(119434555354L);
        clienteDao.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        boolean retorno = clienteDao.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }
    public void excluirCliente() {
        clienteDao.excluir(cliente.getCpf());
    }

    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Josué");
        clienteDao.alterar(cliente);
    }
}
