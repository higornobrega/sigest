package br.ufrn.cerescaico.bsi.sigest;

import java.io.Serializable;
import java.util.List;

import br.ufrn.cerescaico.bsi.sigest.bo.AvaliacaoBO;
import br.ufrn.cerescaico.bsi.sigest.bo.CursoBO;
import br.ufrn.cerescaico.bsi.sigest.bo.NegocioException;
import br.ufrn.cerescaico.bsi.sigest.bo.ProfessorBO;
import br.ufrn.cerescaico.bsi.sigest.model.Avaliacao;
import br.ufrn.cerescaico.bsi.sigest.model.Curso;
import br.ufrn.cerescaico.bsi.sigest.model.Professor;

/**
 * Fachada do sistema Sigest.
 * 
 * @author Taciano de Morais Silva - tacianosilva@gmail.com
 * @version 25/10/2012, Taciano de Morais Silva - tacianosilva@gmail.com
 * @since 25/10/2012
 */
public final class Sigest extends AbstractFacade implements Serializable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instância única da fachada.
	 */
	private static volatile Sigest instance = null;

	/**
	 * Construtor privado da fachada.
	 */
	private Sigest() {
	}

	/**
	 * Retorna a instância única do singleton Sigest (fachada).
	 * 
	 * @return A instância do Sepe.
	 */
	public static Sigest getInstance() {
		if (instance == null) {
			synchronized (Sigest.class) {
				Sigest inst = instance;
				if (inst == null) {
					instance = new Sigest();
				}
			}
		}
		return instance;
	}
	
	public Curso inserirCurso(Curso curso) throws NegocioException {
		CursoBO bo = createCursoBO();
        return bo.inserir(curso);
    }
    
    public List<Curso> listarCursos() throws NegocioException {
        CursoBO bo = createCursoBO();
        return bo.listar();
    }

	public List<Professor> listarProfessores() throws NegocioException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Curso cadastrarCurso(Curso curso) throws NegocioException {
		CursoBO bo = createCursoBO();
        return bo.inserir(curso);
    }
    
    public Curso buscarCurso(Integer id) throws NegocioException{
    	CursoBO bo = createCursoBO();
        return bo.buscarCurso(id);
    }
    
    public Curso buscarCursoPorNome(String nome) throws NegocioException{
    	CursoBO bo =createCursoBO();
    	return bo.buscarCursoPorNome(nome);
    }
    
    public Professor cadastrarProfessor(Professor professor) throws NegocioException{
    	ProfessorBO boProf = createProfessorBO();
    	return boProf.inserir(professor);
    }
    
    public List<Professor> listarProfessor() throws NegocioException{
    	ProfessorBO boProf = createProfessorBO();
    	return boProf.listar();
    }
    
    public Avaliacao cadastrarAvaliacao(Avaliacao avaliacao) throws NegocioException {
		AvaliacaoBO bo = createAvaliacaoBO();
        return bo.inserir(avaliacao);
    }
    
    public List<Avaliacao> listarAvaliacoes() throws NegocioException {
        AvaliacaoBO bo = createAvaliacaoBO();
        return bo.listar();
    }
    
    public List<Avaliacao> listarAvaliacoesProf(int codProf) throws NegocioException {
        AvaliacaoBO bo = createAvaliacaoBO();
        return bo.buscarAvaliacaoPorProf(codProf);
    }
}
