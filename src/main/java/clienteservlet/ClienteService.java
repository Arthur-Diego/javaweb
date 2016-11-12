package clienteservlet;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {

	private static List<Cliente> lista = new ArrayList<>();

	public void cadastrar(Cliente cliente) {
		lista.add(cliente);
	}

	public void salvar(String indice, Cliente cliente) {
		if (!indice.equals("-1")) {
			lista.set(Integer.parseInt(indice), cliente);
		}else {
			cadastrar(cliente);
		}
	}

	public List<Cliente> getLista() {
		return lista;
	}

	public void excluir(int i) {
		lista.remove(i);
	}

	public Cliente buscarPorIndice(int i) {
		return this.lista.get(i);
	}
}
