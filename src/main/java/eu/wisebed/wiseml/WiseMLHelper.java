package eu.wisebed.wiseml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import javax.xml.bind.JAXB;
import java.io.*;
import java.util.*;

public class WiseMLHelper {

	private static final Logger log = LoggerFactory.getLogger(WiseMLHelper.class);

	private WiseMLHelper() {
		// forbid access
	}

	/**
	 * De-serializes the WiseML document and returns the object representation of the parsed document.
	 *
	 * @param serializedWiseML
	 * 		the serialized WiseML document
	 *
	 * @return the object representation of the parsed document
	 */
	@SuppressWarnings("unused")
	public static Wiseml deserialize(final String serializedWiseML) {
		return JAXB.unmarshal(new StringReader(serializedWiseML), Wiseml.class);
	}

	/**
	 * Parses the serialized WiseML document and returns the {@link Setup.Node} instance with URN {@code nodeID}.
	 *
	 * @param serializedWiseML
	 * 		the serialized WiseML document
	 * @param nodeID
	 * 		the URN of the node to return
	 *
	 * @return the {@link Setup.Node} instance with URN {@code nodeID}
	 */
	@SuppressWarnings("unused")
	public static Setup.Node getNode(final String serializedWiseML, final String nodeID) {

		Wiseml wiseml = deserialize(serializedWiseML);

		for (Setup.Node node : wiseml.getSetup().getNode()) {
			if (node.getId().equals(nodeID)) {
				return node;
			}
		}

		return null;
	}

	/**
	 * Reads out all nodes that are contained in the setup-part of the document.
	 *
	 * @param wiseml
	 * 		a serialized WiseML document
	 *
	 * @return a List of {@link Setup.Node} instances
	 */
	@SuppressWarnings("unused")
	public static List<Setup.Node> getNodes(final Wiseml wiseml) {
		return getNodes(wiseml, (String[]) null);
	}

	/**
	 * Parses the WiseML document that is passed in as String in {@code serializedWiseML} and reads out all nodes that are
	 * contained in the setup-part of the document.
	 *
	 * @param serializedWiseML
	 * 		a serialized WiseML document
	 *
	 * @return a List of {@link Setup.Node} instances
	 */
	@SuppressWarnings("unused")
	public static List<Setup.Node> getNodes(final String serializedWiseML) {
		return getNodes(serializedWiseML, (String[]) null);
	}

	/**
	 * Parses the WiseML document that is passed in as String in {@code serializedWiseML} and reads out all nodes that are
	 * contained in the setup-part of the document.
	 *
	 * @param serializedWiseML
	 * 		a serialized WiseML document
	 * @param types
	 * 		node types to include, e.g. "isense", "telosb" will include all iSense and all TelosB nodes
	 * 		contained in the WiseML document
	 *
	 * @return a List of {@link Setup.Node} instances
	 */
	@SuppressWarnings("unused")
	public static List<Setup.Node> getNodes(final String serializedWiseML, @Nullable final Iterable<String> types) {
		return getNodes(deserialize(serializedWiseML), types);
	}

	/**
	 * Parses the WiseML document that is passed in as String in {@code serializedWiseML} and reads out all nodes that are
	 * contained in the setup-part of the document.
	 *
	 * @param serializedWiseML
	 * 		a serialized WiseML document
	 * @param types
	 * 		node types to include, e.g. "isense", "telosb" will include all iSense and all TelosB nodes
	 * 		contained in the WiseML document
	 *
	 * @return a List of {@link Setup.Node} instances
	 */
	@SuppressWarnings("unused")
	public static List<Setup.Node> getNodes(final String serializedWiseML, @Nullable final String... types) {
		return getNodes(deserialize(serializedWiseML), types);
	}

	/**
	 * Reads out all nodes that are contained in the setup-part of the document.
	 *
	 * @param wiseml
	 * 		the WiseML document
	 * @param types
	 * 		node types to include, e.g. "isense", "telosb" will include all iSense and all TelosB nodes contained
	 * 		in the WiseML document
	 *
	 * @return a List of {@link Setup.Node} instances
	 */
	@SuppressWarnings("unused")
	public static List<Setup.Node> getNodes(final Wiseml wiseml, @Nullable final Iterable<String> types) {

		List<Setup.Node> nodes = new ArrayList<Setup.Node>();

		for (Setup.Node node : wiseml.getSetup().getNode()) {
			if (types == null || !types.iterator().hasNext()) {
				nodes.add(node);
			} else {
				// if "containsIgnoreCase"...
				for (String nodeType : types) {
					if (nodeType.equalsIgnoreCase(node.getNodeType())) {
						nodes.add(node);
					}
				}
			}
		}

		return nodes;
	}

	/**
	 * Reads out all nodes that are contained in the setup-part of the document.
	 *
	 * @param wiseml
	 * 		the WiseML document
	 * @param types
	 * 		node types to include, e.g. "isense", "telosb" will include all iSense and all TelosB nodes contained
	 * 		in the WiseML document
	 *
	 * @return a List of {@link Setup.Node} instances
	 */
	@SuppressWarnings("unused")
	public static List<Setup.Node> getNodes(final Wiseml wiseml, @Nullable final String... types) {
		List<String> typesList = null;
		if (types != null) {
			typesList = new ArrayList<String>();
			Collections.addAll(typesList, types);
		}
		return getNodes(wiseml, typesList);
	}

	/**
	 * Parses the WiseML document that is passed in as String in {@code wiseML} and reads out all node URNs that are
	 * contained in the setup-part of the document.
	 *
	 * @param serializedWiseML
	 * 		a serialized WiseML document
	 *
	 * @return a List of node URNs
	 */
	@SuppressWarnings("unused")
	public static List<String> getNodeUrns(final String serializedWiseML) {
		return getNodeUrns(serializedWiseML, (String[]) null);
	}

	/**
	 * Parses the WiseML document that is passed in as String in {@code serializedWiseML} and reads out all node URNs that
	 * are contained in the setup-part of the document.
	 *
	 * @param serializedWiseML
	 * 		a serialized WiseML document
	 * @param types
	 * 		node types to include, e.g. "isense", "telosb" will include all iSense and all TelosB nodes
	 * 		contained in the WiseML document
	 *
	 * @return a List of node URNs
	 */
	@SuppressWarnings("unused")
	public static List<String> getNodeUrns(final String serializedWiseML, @Nullable final Iterable<String> types) {
		List<String> nodeUrns = new LinkedList<String>();
		for (Setup.Node node : getNodes(serializedWiseML, types)) {
			nodeUrns.add(node.getId());
		}
		return nodeUrns;
	}

	/**
	 * Parses the WiseML document that is passed in as String in {@code serializedWiseML} and reads out all node URNs that
	 * are contained in the setup-part of the document.
	 *
	 * @param serializedWiseML
	 * 		a serialized WiseML document
	 * @param types
	 * 		node types to include, e.g. "isense", "telosb" will include all iSense and all TelosB nodes
	 * 		contained in the WiseML document
	 *
	 * @return a List of node URNs
	 */
	@SuppressWarnings("unused")
	public static List<String> getNodeUrns(final String serializedWiseML, @Nullable final String... types) {
		List<String> typesList = null;
		if (types != null) {
			typesList = new ArrayList<String>();
			Collections.addAll(typesList, types);
		}
		return getNodeUrns(serializedWiseML, typesList);
	}

	/**
	 * Returns a prettily formatted and indented version of the given serialized WiseML document in {@code
	 * serializedWiseML}.
	 *
	 * @param serializedWiseML
	 * 		the serialized WiseML document
	 *
	 * @return a prettily formatted and indented serialized WiseML document
	 */
	@SuppressWarnings("unused")
	public static String prettyPrintWiseML(final String serializedWiseML) {
		return serialize(deserialize(serializedWiseML));
	}

	/**
	 * Reads a WiseML document from a file and returns it serialized and prettily formatted and indented.
	 *
	 * @param filename
	 * 		the name of the file to read from
	 *
	 * @return a serialized and prettily formatted and indented WiseML document or {@code null} if an error occurs
	 */
	@SuppressWarnings("unused")
	public static String readWiseMLFromFile(final String filename) {

		File wiseMLFile = new File(filename);

		if (!wiseMLFile.exists()) {
			log.error("WiseML file {} does not exist!", wiseMLFile.getAbsolutePath());
			return null;
		} else if (wiseMLFile.isDirectory()) {
			log.error("WiseML file name {} points to a directory!", wiseMLFile.getAbsolutePath());
			return null;
		} else if (!wiseMLFile.canRead()) {
			log.error("WiseML file {} can't be read!", wiseMLFile.getAbsolutePath());
			return null;
		}

		try {

			BufferedReader wiseMLFileReader = new BufferedReader(new FileReader(wiseMLFile));
			StringBuilder wiseMLBuilder = new StringBuilder();

			while (wiseMLFileReader.ready()) {
				wiseMLBuilder.append(wiseMLFileReader.readLine());
			}

			return prettyPrintWiseML(wiseMLBuilder.toString());

		} catch (IOException e) {
			log.error("" + e, e);
			return null;
		}

	}

	/**
	 * Serializes the {@link Wiseml} instance.
	 *
	 * @param wiseML
	 * 		the {@link Wiseml} instance to serialize
	 *
	 * @return the serialized WiseML document
	 */
	@SuppressWarnings("unused")
	public static String serialize(final Wiseml wiseML) {
		StringWriter writer = new StringWriter();
		JAXB.marshal(wiseML, writer);
		return writer.toString();
	}

	/**
	 * Returns a String representation of {@code node}.
	 *
	 * @param node
	 * 		the {@link Setup.Node} instance
	 *
	 * @return a String representation of {@code node}
	 */
	@SuppressWarnings("unused")
	public static String toString(Setup.Node node) {
		return "Node{" +
				"id='" + node.getId() + '\'' +
				", capability=" + toString(node.getCapability()) +
				", position=" + toString(node.getPosition()) +
				", gateway=" + node.isGateway() +
				", programDetails='" + node.getProgramDetails() + '\'' +
				", nodeType='" + node.getNodeType() + '\'' +
				", description='" + node.getDescription() + '\'' +
				"}";
	}

	/**
	 * Returns a String representation of {@code capabilities}.
	 *
	 * @param capabilities
	 * 		the {@link List<Capability>} instance
	 *
	 * @return a String representation of {@code capabilities}
	 */
	@SuppressWarnings("unused")
	public static String toString(List<Capability> capabilities) {
		List<String> strings = new ArrayList<String>(capabilities.size());
		for (Capability capability : capabilities) {
			strings.add(toString(capability));
		}
		return Arrays.toString(strings.toArray());
	}

	/**
	 * Returns a String representation of {@code capability}.
	 *
	 * @param capability
	 * 		the {@link Capability} instance
	 *
	 * @return a String representation of {@code capability}
	 */
	@SuppressWarnings("unused")
	public static String toString(Capability capability) {
		return "Capability{" +
				"_default='" + capability.getDefault() + '\'' +
				", name='" + capability.getName() + '\'' +
				", datatype=" + capability.getDatatype() +
				", unit=" + capability.getUnit() +
				'}';
	}

	/**
	 * Returns a String representation of {@code nodeProperties}.
	 *
	 * @param nodeProperties
	 * 		the {@link NodeProperties} instance
	 *
	 * @return a String representation of {@code nodeProperties}
	 */
	@SuppressWarnings("unused")
	public static String toString(NodeProperties nodeProperties) {
		return "NodeProperties{" +
				"capability=" + toString(nodeProperties.getCapability()) +
				", position=" + toString(nodeProperties.getPosition()) +
				", gateway=" + nodeProperties.isGateway() +
				", programDetails='" + nodeProperties.getProgramDetails() + '\'' +
				", nodeType='" + nodeProperties.getNodeType() + '\'' +
				", description='" + nodeProperties.getDescription() + '\'' +
				'}';
	}

	/**
	 * Returns a String representation of {@code position}.
	 *
	 * @param position
	 * 		the {@link Coordinate} instance
	 *
	 * @return a String representation of {@code position}
	 */
	@SuppressWarnings("unused")
	private static String toString(final Coordinate position) {
		return "Coordinate{" +
				"x=" + position.getX() +
				", y=" + position.getY() +
				", z=" + position.getZ() +
				", phi=" + position.getPhi() +
				", theta=" + position.getTheta() +
				'}';
	}

}
