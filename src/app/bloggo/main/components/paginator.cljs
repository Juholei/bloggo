(ns bloggo.main.components.paginator)

(defn page-link [current-page? text destination]
  [:a {:href destination}
   (if current-page?
     [:b text]
     text)])

(defn paginator [current-page page-count url-fn]
  [:div
   (for [page-num (range 1 (inc page-count))
         :let [current-page? (= current-page page-num)]]
     ^{:key page-num}
     [page-link current-page? page-num (url-fn page-num)])])
