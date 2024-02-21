package br.senac.helpu.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

public class ConversorImagem {

	public static byte[] obterBytes(Part parteImagem) throws IOException {
		InputStream imagemInputStream = parteImagem.getInputStream();

		return IOUtils.toByteArray(imagemInputStream);
	}

	public static String utlFoto(byte[] foto, String extensao) {
		String urlfoto = ("data:" + extensao + ";base64," + Base64.getEncoder().encodeToString(foto));
		return urlfoto;

	}

}
