package Lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumberSet;

    private LottoNumbers(final Set<LottoNumber> lottoNumberSet) {
        validateLottoSize(lottoNumberSet);
        this.lottoNumberSet = new TreeSet<>(lottoNumberSet);
    }

    public static LottoNumbers of(final Set<LottoNumber> lottoNumberSet) {
        return new LottoNumbers(lottoNumberSet);
    }

    public static LottoNumbers of(final List<Integer> numbers) {
        return new LottoNumbers(numbers.stream().map(LottoNumber::from).collect(Collectors.toSet()));
    }

    private void validateLottoSize(final Set<LottoNumber> lottoNumberSet) {
        final int lottoSize = lottoNumberSet.size();
        if (lottoSize != LOTTO_SIZE) {
            throw new IllegalArgumentException("Size of Lotto is wrong: " + lottoSize);
        }
    }

    public int match(final LottoNumbers winningNumbers) {
        return this.lottoNumberSet.stream().mapToInt(winningNumbers::increment).sum();
    }

    public int increment(final LottoNumber number) {
        return this.lottoNumberSet.contains(number) ? 1 : 0;
    }
}
