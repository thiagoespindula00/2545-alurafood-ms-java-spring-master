package br.com.alurafood.pedidos.amqp;

import br.com.alurafood.pedidos.dto.PagamentoDTO;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class PagamentoListener {
    @RabbitListener(queues = "pagamentos.detalhes-pedido")
    public void recebeMensagem(PagamentoDTO pagamentoDTO) {
        String mensagem = """
                Dados do pagamento: %s
                Número do pedido: %s
                Valor R$: %s
                Status: %s
                """.formatted(pagamentoDTO.getId(), pagamentoDTO.getPedidoId(), pagamentoDTO.getValor(), pagamentoDTO.getStatus());

        System.out.println(mensagem);
    }
}
