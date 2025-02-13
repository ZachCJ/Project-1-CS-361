package fa.dfa;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class DFAMap<DFAState, DFAPathMap> implements Map<DFAState, DFAPathMap> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public DFAPathMap get(Object key) {
        return null;
    }

    @Override
    public DFAPathMap put(DFAState key, DFAPathMap value) {
        return null;
    }

    @Override
    public DFAPathMap remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends DFAState, ? extends DFAPathMap> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<DFAState> keySet() {
        return null;
    }

    @Override
    public Collection<DFAPathMap> values() {
        return null;
    }

    @Override
    public Set<Entry<DFAState, DFAPathMap>> entrySet() {
        return null;
    }
}