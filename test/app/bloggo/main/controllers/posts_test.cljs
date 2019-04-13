(ns bloggo.main.controllers.posts-test
  (:require [bloggo.main.controllers.posts :as sut]
            [cljs.test :refer [deftest testing is]]
            [tuck.core :as tuck]))

(def test-blog-post {:title "Test post"})

(deftest test-add-posts
  (testing "add-posts adds given posts to empty vector"
    (is (= (sut/add-posts [] [{:title "Test post"}])
           [{:title "Test post"}])))

  (testing "add-posts does not produce duplicate posts, if new posts are already in the existing"
    (is (= (sut/add-posts [{:title "Test post"}] [{:title "Test post"}])
           [{:title "Test post"}])))

  (testing "add-posts adds new posts to the end"
    (is (= (sut/add-posts [{:title "Old post"}] [{:title "New post"}])
           [{:title "Old post"} {:title "New post"}])))

  (testing "Tuck event AddPosts sets the posts in the correct place in the app-state"
    (is (= (tuck/process-event (sut/->AddPosts [{:title "Test post"}]) {})
           {:posts [{:title "Test post"}]}))))

(deftest test-GetPosts
  (testing "GetPosts set in-progress? to true"
    (is (true? (-> (sut/->GetPosts 0)
                   (tuck/process-event {})
                   .-app
                   :in-progress?))))
  (testing "GetPosts request url uses the given page number"
    (is (= (-> (sut/->GetPosts 2)
               (tuck/process-event {})
               .-effects
               first
               :path)
           "/posts/2"))))

