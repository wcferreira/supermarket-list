(ns supermarket-list.supermarket)

(def supermarket (atom []))


(defn add-item!
  [item]
  (swap! supermarket conj item))

(defn remove-all!
  []
  (when-not (empty? @supermarket)
    (swap! supermarket pop)
    (recur)))

