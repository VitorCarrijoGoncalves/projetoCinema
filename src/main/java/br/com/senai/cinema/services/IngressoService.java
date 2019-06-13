package br.com.senai.cinema.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.senai.cinema.dto.IngressoDTO;
import br.com.senai.cinema.models.Ingresso;
import br.com.senai.cinema.models.Secao;
import br.com.senai.cinema.models.Usuario;
import br.com.senai.cinema.repositories.IngressoRepository;
import br.com.senai.cinema.repositories.SecaoRepository;
import br.com.senai.cinema.repositories.UsuarioRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class IngressoService {

	@Autowired
	private IngressoRepository ingressoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private SecaoRepository secaoRepository;
	
	public Ingresso save(Ingresso obj) {
		obj.setId(null); // o Objeto novo a ser inserido precisa o ter p id nulo
		return ingressoRepository.save(obj);
	}
	
	public Ingresso findById(Integer id) throws ObjectNotFoundException {
		Ingresso Ingresso = ingressoRepository.findById(id);
		if (Ingresso == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id = " + id + ", Tipo: " + Ingresso.class.getName());
		}
		return Ingresso;
	}
	
	public Ingresso update(Ingresso obj) {
		if (obj.getId() != null) {
			return ingressoRepository.save(obj); // id nulo, objeto inserido, id diferente de nulo, objeto a ser atualizado
		}
		return null;
	}
	
	public void delete(Ingresso ingresso) {
		if (ingresso != null) {
			ingressoRepository.delete(ingresso);
		}
	}
	
	public void deleteById(Integer id) {
		if (id != null ) {
			ingressoRepository.deleteById(id);
		}
	}
	
	public List<Ingresso> findAll() {
		return ingressoRepository.findAll();
	}
	
	public boolean validarIngresso(IngressoDTO ingressoDTO) {
		
		Usuario usuario = usuarioRepository.findById(ingressoDTO.getIdUsuario());
		Secao secao = secaoRepository.findById(ingressoDTO.getIdSecao());
		
		if (usuario == null || secao == null) {
			return false;
		} else {
			return true;
		}
		
		
	}
	
	public Ingresso convertIngresso(IngressoDTO ingressoDTO) {
		
		Ingresso ingresso = new Ingresso();
		
		Usuario usuario = usuarioRepository.findById(ingressoDTO.getIdUsuario());
		
		ingresso.setIdUsuario(usuario);
		
		Secao secao = secaoRepository.findById(ingressoDTO.getIdSecao());
		
		ingresso.setIdSecao(secao);
		
		ingresso.setTipoIngresso(ingressoDTO.getTipoIngresso());
		
		return ingresso;
		
	}
	
	public void gerarComprovanteDePagamento(Ingresso ingresso) throws FileNotFoundException, DocumentException {
		
		String enderecoArquivo = "C:\\Users\\Vitor\\Downloads\\pdf\\" + new Date() + ingresso.getIdUsuario().getNome() + ".pdf";
		
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(enderecoArquivo.replaceAll(" ", "-").replaceAll(":", "")));
		 
		document.open();
		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		
		Chunk chunk1 = new Chunk("Nome = " + ingresso.getIdUsuario().getNome(), font);
		document.add(chunk1);
		
		Chunk chunk2 = new Chunk("Filme = " + ingresso.getIdSecao().getIdFilme(), font);
		document.add(chunk2);
		
		Chunk chunk3 = new Chunk("Sala = " + ingresso.getIdSecao().getIdSala().getNumero(), font);
		document.add(chunk3);
		
		Chunk chunk4 = new Chunk("Horário = " + ingresso.getIdSecao().getHora(), font);
		document.add(chunk4);
		
		document.close();
		
	}
	
}
