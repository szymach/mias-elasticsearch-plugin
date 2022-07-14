/**
 * (c) FSi sp. z o.o. <info@fsi.pl>
 *
 * For the full copyright and license information, please view the LICENSE file
 * that was distributed with this source code.
 */

package mias.elasticsearch.plugin.fsi.elasticsearch.index.analysis;

import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenizerFactory;

public class MathTokenizerFactory extends AbstractTokenizerFactory {

    public MathTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        super(indexSettings, settings, name);
    }

    @Override
    public Tokenizer create() {
        return new MathTokenizer();
    }
}
