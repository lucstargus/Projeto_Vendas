package test.java;

import main.java.Cliente;
import main.java.dao.IClienteDAO;
import main.java.exception.TipoChaveNaoEncontradaException;
import main.java.services.ClienteService;
import main.java.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.java.dao.ClienteDAOMock;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDAOMock();
        clienteService = new ClienteService(dao);
    }
    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12345654380L);
        cliente.setNome("rodney");
        cliente.setCidade("São Paulo");
        cliente.setEnd("Maracanã");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(119434555354L);
    }
    
    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        boolean retorno = clienteService.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Josué");
        clienteService.alterar(cliente);

        Assert.assertEquals("Josué", cliente.getNome());
    }
}