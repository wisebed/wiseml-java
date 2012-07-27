package eu.wisebed.wiseml.merger;

import eu.wisebed.wiseml.merger.config.MergerConfiguration;
import eu.wisebed.wiseml.merger.internals.merge.elements.WiseMLMerger;
import eu.wisebed.wiseml.merger.internals.stream.WiseMLTreeToXMLStream;
import eu.wisebed.wiseml.merger.internals.stream.XMLStreamToWiseMLTree;
import eu.wisebed.wiseml.merger.internals.tree.WiseMLTreeReader;

import javax.xml.stream.XMLStreamReader;
import java.util.List;

/**
 * Multiple WiseML files can by merged into one by calling one of the
 * createMergingWiseMLStreamReader methods with XMLStreamReaders that
 * stream said input files.
 * 
 * The merging behavior can be controlled by providing a
 * MergerConfiguration.
 * 
 * This implementation never reads entire files into memory and is
 * therefore suitable for big inputs. Since there is only one pass
 * for each input, some merging operations may be impossible
 * without further processing of the data beforehand.
 * (see MergerConfiguration).
 * 
 * WiseML files passed to methods of this class are expected to be
 * valid syntactically and semantically.
 * 
 * @author Jacob Kuypers
 *
 */
public class WiseMLMergerFactory {
	
	public static final MergerConfiguration getDefaultConfiguration() {
		return new MergerConfiguration();
	}
	
	public static final XMLStreamReader createMergingWiseMLStreamReader(
			final MergerConfiguration config, 
			final XMLStreamReader... inputReaders) {
		if (inputReaders.length == 0)
			return null;
		if (inputReaders.length == 1)
			return inputReaders[0];

		// turn XMLStreamReaders into WiseMLTreeReaders
		WiseMLTreeReader[] treeReaders = new WiseMLTreeReader[inputReaders.length];
		for (int i = 0; i < inputReaders.length; i++) {
			treeReaders[i] = new XMLStreamToWiseMLTree(inputReaders[i]);
		}

		// merge multiple WiseMLTreeReaders into one
		WiseMLMerger merger = new WiseMLMerger(treeReaders, config);

		// turn the WiseMLMerger into a XMLStreamReader
		XMLStreamReader outputReader = new WiseMLTreeToXMLStream(merger, config);

		return outputReader;
	}
	
	public static final XMLStreamReader createMergingWiseMLStreamReader(
			final XMLStreamReader... inputReaders) {
		return createMergingWiseMLStreamReader(getDefaultConfiguration(), 
				inputReaders);
	}

    public static final XMLStreamReader createMergingWiseMLStreamReader(
			final MergerConfiguration config,
			final List<XMLStreamReader> inputReaders) {
		if (inputReaders.size() == 0)
			return null;
		if (inputReaders.size() == 1)
			return inputReaders.get(0);
		return createMergingWiseMLStreamReader(
				config, inputReaders.toArray(new XMLStreamReader[inputReaders.size()]));
	}

	public static final XMLStreamReader createMergingWiseMLStreamReader(
			final List<XMLStreamReader> inputReaders) {
		return createMergingWiseMLStreamReader(getDefaultConfiguration(),
				inputReaders);
	}

}
