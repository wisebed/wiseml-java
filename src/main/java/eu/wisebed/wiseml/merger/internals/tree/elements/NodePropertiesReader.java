package eu.wisebed.wiseml.merger.internals.tree.elements;

import eu.wisebed.wiseml.merger.internals.Conversions;
import eu.wisebed.wiseml.merger.internals.WiseMLAttribute;
import eu.wisebed.wiseml.merger.internals.WiseMLTag;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLStructureReader;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;
import eu.wisebed.wiseml.merger.structures.Capability;
import eu.wisebed.wiseml.merger.structures.NodeProperties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NodePropertiesReader extends WiseMLStructureReader {

	public NodePropertiesReader(
			final WiseMLTreeReader parent, 
			final NodeProperties nodeProperties) {
		super(new Element(
				parent, 
				WiseMLTag.node, 
				null,
				createSubElementsFromProperties(nodeProperties), 
				null));
	}
	
	public NodePropertiesReader(
			final WiseMLTreeReader parent, 
			final String nodeID, 
			final NodeProperties nodeProperties) {
		super(new Element(
				parent, 
				WiseMLTag.node, 
				new WiseMLAttribute[]{new WiseMLAttribute("id", nodeID)},
				createSubElementsFromProperties(nodeProperties),
				null));
	}

	private static Element[] createSubElementsFromProperties(
			NodeProperties nodeProperties) {
		List<Element> result = new ArrayList<Element>();
		if (nodeProperties.getPosition() != null) {
			result.add(new CoordinateReader(
					null, WiseMLTag.position, 
					nodeProperties.getPosition()).getTopElement());
		}
		if (nodeProperties.getGateway() != null) {
			result.add(createPureTextElement(
					null, WiseMLTag.gateway, 
					Conversions.writeBoolean(nodeProperties.getGateway())));
		}
		if (nodeProperties.getProgramDetails() != null) {
			result.add(createPureTextElement(
					null, WiseMLTag.programDetails,
					nodeProperties.getProgramDetails()));
		}
		if (nodeProperties.getNodeType() != null) {
			result.add(createPureTextElement(
					null, WiseMLTag.nodeType,
					nodeProperties.getNodeType()));
		}
		if (nodeProperties.getDescription() != null) {
			result.add(createPureTextElement(
					null, WiseMLTag.description,
					nodeProperties.getDescription()));
		}
		Collection<Capability> capabilities = nodeProperties.getCapabilities();
		for (Capability capability : capabilities) {
			result.add(new CapabilityReader(null, capability).getTopElement());
		}
		return result.toArray(new Element[result.size()]);
	}

}
