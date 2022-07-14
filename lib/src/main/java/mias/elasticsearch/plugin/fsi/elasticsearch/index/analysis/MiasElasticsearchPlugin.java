/**
 * (c) FSi sp. z o.o. <info@fsi.pl>
 *
 * For the full copyright and license information, please view the LICENSE file
 * that was distributed with this source code.
 */
package mias.elasticsearch.plugin.fsi.elasticsearch.index.analysis;

import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.Map;

import static java.util.Collections.singletonMap;

public class MiasElasticsearchPlugin extends Plugin implements AnalysisPlugin {

    /**
     * Morfologik analyzer name.
     */
    public static final String TOKENIZER_NAME = "mias-math";

    public MiasElasticsearchPlugin() {
    }

    @Override
    public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {
        return singletonMap(TOKENIZER_NAME, MathTokenizerFactory::new);
    }
}
