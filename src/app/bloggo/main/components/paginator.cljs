(ns bloggo.main.components.paginator)

(defn page-link [text destination]
  [:a {:href destination}
   text])

(defn paginator [page-count url-fn]
  [:div
   (for [page-num (range 1 (inc page-count))]
     ^{:key page-num}
     [page-link page-num (url-fn page-num)])])
