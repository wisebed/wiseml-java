package eu.wisebed.wiseml.merger.internals.merge.elements;

import eu.wisebed.wiseml.merger.config.MergerConfiguration;
import eu.wisebed.wiseml.merger.internals.WiseMLSequence;
import eu.wisebed.wiseml.merger.internals.merge.MergerResources;
import eu.wisebed.wiseml.merger.internals.merge.SortedListMerger;
import eu.wisebed.wiseml.merger.internals.merge.WiseMLTreeMerger;
import eu.wisebed.wiseml.merger.internals.parse.elements.NodePropertiesParser;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReaderHelper;
import eu.wisebed.wiseml.merger.internals.tree.elements.NodePropertiesReader;
import eu.wisebed.wiseml.merger.structures.NodeProperties;

import java.util.Collection;

public class NodeListMerger extends SortedListMerger<NodeDefinition> {

	public NodeListMerger(
			final WiseMLTreeMerger parent,
			final WiseMLTreeReader[] inputs, 
			final MergerConfiguration configuration,
			final MergerResources resources) {
		super(parent, inputs, configuration, resources, WiseMLSequence.SetupNode);
	}

	@Override
	protected WiseMLTreeReader mergeItems(Collection<NodeDefinition> items) {
		NodeDefinition firstItem = null;
		String outputID = null;
		NodeProperties outputProperties = null;
		for (NodeDefinition item : items) {
			if (firstItem == null) {
				firstItem = item;
				outputID = firstItem.getId();
				outputProperties = firstItem.getNodeProperties();
			} else {
				if (!item.getNodeProperties().equals(firstItem.getNodeProperties())) {
					// conflict
					// TODO
				}
			}
		}
		
		return new NodePropertiesReader(this, outputID, outputProperties);
	}

	@Override
	protected NodeDefinition readNextItem(int inputIndex) {
		if (!nextSubInputReader(inputIndex)) {
			return null;
		}
		WiseMLTreeReader nodeReader = getSubInputReader(inputIndex);
		
		// parse properties and transform
		NodeProperties properties = 
			new NodePropertiesParser(nodeReader).getParsedStructure();
		properties = resources.getNodePropertiesTransformer().transform(
				properties, inputIndex);
		
		NodeDefinition result = new NodeDefinition(
				WiseMLTreeReaderHelper.getAttributeValue(
						nodeReader.getAttributeList(), "id"),
						properties,
						inputIndex);
		return result;
	}

}
