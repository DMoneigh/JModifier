package com.jmodifier.archive;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

/**
 * Represents a jar file.
 * 
 * @author Desmond Jackson
 */
public class Archive extends Object implements Iterable<ClassNode> {

	/**
	 * The Jar file to represent.
	 */
	private JarFile jarFile;

	/**
	 * The class files found in the represented Jar file.
	 */
	private Map<String, ClassNode> classes = new HashMap<String, ClassNode>();

	/**
	 * The other files found in the represented Jar file.
	 */
	private Map<String, byte[]> otherFiles = new HashMap<String, byte[]>();
	
	/**
	 * Creates the archive.
	 * 
	 * @param jarFile The jar file to represent
	 */
	public Archive(JarFile jarFile) {
		super();
		this.jarFile = jarFile;
		Enumeration<JarEntry> entries = jarFile.entries();
		while (entries.hasMoreElements()) {
			JarEntry entry = entries.nextElement();
			String name = entry.getName();
			if (name.endsWith(".class"))
				try {
					ClassReader reader = new ClassReader(jarFile.getInputStream(entry));
					ClassNode node = new ClassNode();
					reader.accept(node, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
					classes.put(name.replace(".class", ""), node);
				} catch (IOException e) {
					e.printStackTrace();
				}
			else
				try {
					InputStream in = jarFile.getInputStream(entry);
					byte[] bytes = new byte[1024];
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					int count = 0;
					while ((count = in.read(bytes)) != -1)
						baos.write(bytes, 0, count);
					in.close();
					otherFiles.put(name, baos.toByteArray());
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * Adds a class node by class.
	 * 
	 * @param clazz The class
	 */
	public void addClassNode(Class<?> clazz) {
		try {
			ClassReader cr = new ClassReader(clazz.getName());
			ClassNode node = new ClassNode();
			cr.accept(node, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
			classes.put(node.name, node);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the bytes of an other file.
	 * 
	 * @param name The other file name
	 * 
	 * @return The bytes of an other file
	 */
	public byte[] getBytesOfOtherFile(String name) {
		return otherFiles.get(name);
	}

	/**
	 * Gets the bytes of a class node.
	 * 
	 * @param node The class node
	 * 
	 * @return The bytes of a class node
	 */
	public byte[] getBytesOfClassNode(ClassNode node) {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
		node.accept(cw);
		return cw.toByteArray();
	}

	/**
	 * Gets a class node by name.
	 * 
	 * @param name The class node name
	 * 
	 * @return A class node by name
	 */
	public ClassNode getClassNode(String name) {
		return classes.get(name);
	}

	/**
	 * Gets the main class name.
	 * 
	 * @return null if the main class could not be obtained
	 */
	public String getMainClassName() {
		try {
			return jarFile.getManifest().getMainAttributes().getValue("Main-Class");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Iterator<ClassNode> iterator() {
		return classes.values().iterator();
	}

}
