package com.desafioMicroservicos.microservices;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.exceptions.verification.WantedButNotInvoked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.desafioMicroservicos.microservices.entity.FormaDePagamento;
import com.desafioMicroservicos.microservices.entity.Pagamento;
import com.desafioMicroservicos.microservices.entity.Status;
import com.desafioMicroservicos.microservices.repository.PagamentoRepository;
import com.desafioMicroservicos.microservices.services.PagamentoServiceImp;

@DisplayName("PagamentoServiceTest")
public class PagamentoServiceTest extends MicroservicesApplicationTests {

	@MockBean
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private PagamentoServiceImp pagamentoService;
	
	
	@Test
	@DisplayName("Deve deletar um pagamento")
	public void excluir() {
		
		Long idPag = new Long(2);
		Optional<Pagamento> pagamento = Optional.of(criarPag());
		Mockito.when(pagamentoRepository.findById(idPag)).thenReturn(pagamento);
		pagamentoService.delete(idPag);
		Mockito.verify(pagamentoRepository,Mockito.times(wantedNumberOfInvocations: 1)).delete(ArgumentMatchers.any(Pagamento.class));
	}


	private Pagamento criarPag() {
		Pagamento pag = Mockito.mock(Pagamento.class);
		Mockito.when(pag.getNome()).thenReturn(new String("Kiko"));
		Mockito.when(pag.getValor()).thenReturn(BigDecimal.TEN);
		Mockito.when(pag.getExpiracao()).thenReturn(new String("23/08/1995"));
		Mockito.when(pag.getCodigo()).thenReturn(new String("123"));
		Mockito.when(pag.getFormaDePagamento()).thenReturn(FormaDePagamento.CARTAO_CREDITO);
		Mockito.when(pag.getNumero()).thenReturn(new String("123"));
		Mockito.when(pag.getStatus()).thenReturn(Status.CONFIRMADO);
		Mockito.when(pag.getPedidoId()).thenReturn(new Long(1));
		return pag;
	}

}
