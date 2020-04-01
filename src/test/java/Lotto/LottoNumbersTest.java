package Lotto;

import Lotto.domain.LottoNumber;
import Lotto.domain.LottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {
    private Set<LottoNumber> lackNumberSet = new TreeSet<>();
    private LottoNumbers numbers;

    @BeforeEach
    void setUp() {
        lackNumberSet.add(LottoNumber.newInstance(1));
        lackNumberSet.add(LottoNumber.newInstance(4));
        lackNumberSet.add(LottoNumber.newInstance(6));
        lackNumberSet.add(LottoNumber.newInstance(14));
        lackNumberSet.add(LottoNumber.newInstance(24));

        final Set<LottoNumber> lottoNumbers = new TreeSet<>();
        lottoNumbers.add(LottoNumber.newInstance(1));
        lottoNumbers.add(LottoNumber.newInstance(4));
        lottoNumbers.add(LottoNumber.newInstance(6));
        lottoNumbers.add(LottoNumber.newInstance(14));
        lottoNumbers.add(LottoNumber.newInstance(24));
        lottoNumbers.add(LottoNumber.newInstance(30));

        numbers = new LottoNumbers(lottoNumbers);
    }

    @Test
    @DisplayName("로또 부족한 형태로 생성시 에러 발생")
    void ErrorOnLottoNumberSizeTest() {
        assertThatThrownBy(() -> {
            new LottoNumbers(lackNumberSet);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또에서 숫자가 잘 들어있는지 확인하는 테스트")
    void containsTest() {
        final LottoNumber number = LottoNumber.newInstance(6);
        assertThat(numbers.contains(number)).isTrue();
    }
}
