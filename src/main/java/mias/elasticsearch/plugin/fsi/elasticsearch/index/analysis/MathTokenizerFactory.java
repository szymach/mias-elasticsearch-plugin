/**
 * (c) FSi sp. z o.o. <info@fsi.pl>
 *
 * For the full copyright and license information, please view the LICENSE file
 * that was distributed with this source code.
 */
package mias.elasticsearch.plugin.fsi.elasticsearch.index.analysis;

import cz.muni.fi.mias.math.MathTokenizer;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.util.AttributeFactory;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenizerFactory;

public class MathTokenizerFactory extends AbstractTokenizerFactory {
    private final boolean subformulae;
    private final boolean reduceWeights;
    private final MathTokenizer.MathMLType type;

    public MathTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        super(indexSettings, settings, name);

        subformulae = settings.getAsBoolean("subformulae", true);
        reduceWeights = settings.getAsBoolean("reduceWeights", true);
        type = MathTokenizer.MathMLType.valueOf(settings.get("use_type", "BOTH"));
    }

    @Override
    public Tokenizer create() {
        return new MathTokenizer(AttributeFactory.DEFAULT_ATTRIBUTE_FACTORY, subformulae, type, reduceWeights);
    }
}
