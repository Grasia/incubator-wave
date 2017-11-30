package org.swellrt.beta.client.platform.java;

import org.swellrt.beta.common.ModelFactory;
import org.swellrt.beta.common.SException;
import org.swellrt.beta.model.SNode;
import org.swellrt.beta.model.SUtils;
import org.swellrt.beta.model.SVisitor;
import org.swellrt.beta.model.local.STextLocal;
import org.swellrt.beta.model.wave.SubstrateId;
import org.swellrt.beta.model.wave.mutable.SWaveNodeManager;
import org.swellrt.beta.model.wave.mutable.SWaveText;
import org.waveprotocol.wave.client.wave.InteractiveDocument;
import org.waveprotocol.wave.model.document.operation.DocInitialization;
import org.waveprotocol.wave.model.wave.Blip;

public class JavaModelFactory extends ModelFactory {

  @Override
  public SWaveText createWaveText(SWaveNodeManager nodeManager, SubstrateId substrateId, Blip blip,
      InteractiveDocument doc) {

    return new SWaveText(nodeManager, substrateId, blip) {

      @Override
      public String getRawContent() {
        return blip.getContent().toXmlString();
      }

      @Override
      public DocInitialization getInitContent() {
        return blip.getContent().toInitialization();
      }

      @Override
      public void setInitContent(DocInitialization ops) {
        throw new IllegalStateException("Not implemented");
      }

      @Override
      public boolean isEmpty() {
        return SUtils.isEmptyDocument(blip.getContent());
      }

      @Override
      public void accept(SVisitor visitor) {
        visitor.visit(this);
      }

      @Override
      public void set(String path, Object value) {
      }

      @Override
      public Object get(String path) {
        return null;
      }

      @Override
      public void push(String path, Object value) {
      }

      @Override
      public Object pop(String path) {
        return null;
      }

      @Override
      public void delete(String path) {
      }

      @Override
      public int length(String path) {
        return 0;
      }

      @Override
      public boolean contains(String path, String property) {
        return false;
      }

      @Override
      public SNode node(String path) {
        return null;
      }

    };

  }

  @Override
  public STextLocal createLocalText(String text) throws SException {
    throw new IllegalStateException("Not implemented yet");
  }
}