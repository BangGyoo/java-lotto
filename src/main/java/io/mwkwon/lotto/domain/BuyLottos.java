package io.mwkwon.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BuyLottos {
    private final List<Lotto> lottos;

    public BuyLottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyLottos buyLottos1 = (BuyLottos) o;
        return Objects.equals(lottos, buyLottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
