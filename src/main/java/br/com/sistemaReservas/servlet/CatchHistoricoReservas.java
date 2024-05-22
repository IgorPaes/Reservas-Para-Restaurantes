package br.com.sistemaReservas.servlet;

public class CatchHistoricoReservas {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DAOReserva daoReserva = new DAOReserva(); 
        List<Reserva> reservas = daoReserva.capturaReservas();

        // System.out.println(reservas.size());
        // System.out.println("----------------------------------------");
        // System.out.println(reservas.getFirst().getId());
        // System.out.println(reservas.getFirst().getIdRestaurante());
        // System.out.println(reservas.getFirst().getIdCliente());
        // System.out.println(reservas.getFirst().getData());
        // System.out.println(reservas.getFirst().getHorario());
        // System.out.println(reservas.getFirst().getQtdPessoas());
        // System.out.println(reservas.getFirst().getComentario());
        // System.out.println(reservas.getFirst().getStatus());
        // System.out.println("----------------------------------------");

        if (reservas != null) {
            response.sendRedirect("/pages/gerenciamento/cliente/minhas-reservas/minhas-reservas.jsp");
            request.setAttribute("reservas", reservas);
            request.getRequestDispatcher("/pages/gerenciamento/cliente/minhas-reservas/minhas-reservas.jsp").forward(request, response);
        } else {
            System.out.println("Nenhum reserva foi encontrada!");
        }
        
    }
    
}
