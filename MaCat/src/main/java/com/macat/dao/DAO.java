package com.macat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.macat.dto.CartsDTO;
import com.macat.dto.CtgriesDTO;
import com.macat.dto.FaqDTO;
import com.macat.dto.FaqSearchDTO;
import com.macat.dto.ImagesDTO;
import com.macat.dto.MberGradDTO;
import com.macat.dto.MbersDTO;
import com.macat.dto.MbersSearchDTO;
import com.macat.dto.NotsDTO;
import com.macat.dto.NotsSearchDTO;
import com.macat.dto.ProductsDTO;
import com.macat.dto.ProductsSearchDTO;
import com.macat.dto.QnaDTO;
import com.macat.dto.QnaSearchDTO;

@Repository
public class DAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	
	/*////////////////////////////////// 메인 //////////////////////////////////*/

	
	// 회원가입
	public int getJoin(MbersDTO mbersDTO) {
		return sqlSessionTemplate.insert("join", mbersDTO);
	}

	// 로그인
	public MbersDTO getLogin(MbersDTO mbersDTO) {
		return sqlSessionTemplate.selectOne("login", mbersDTO);
	}

	// 접속일 업데이트
	public int getLoginRecord(MbersDTO mbersDTO) {
		return sqlSessionTemplate.update("login_record", mbersDTO);
	}
	
	// 회원 등급 조회
	public List<MberGradDTO> getMberGradList() {
		return sqlSessionTemplate.selectList("mber_grad_list");
	}
	
	// 문의 카테고리 조회
	public List<CtgriesDTO> getQnaCtgriesList() {
		return sqlSessionTemplate.selectList("qna_ctgries_list");
	}
	
	// 장바구니 조회
	public List<CartsDTO> getCarts(String mber_sq) {
		return sqlSessionTemplate.selectList("cart", mber_sq);
	}
	
	
	/*////////////////////////////////// 카테고리 //////////////////////////////////*/
	
	
	// 모든 카테고리 가져오기
	public List<CtgriesDTO> getCategories() {
		return sqlSessionTemplate.selectList("categories");
	}
	
	// 카테고리 그룹 가져오기
	public List<CtgriesDTO> getCategoryGroup(int ctgry_group) {
		return sqlSessionTemplate.selectList("ctgry_group", ctgry_group);
	}
	
	
	/*////////////////////////////////// 상품 조회 //////////////////////////////////*/
	
	
	// 전체 상품 갯수
	public int getProductsCount(int prduct_ctgry_group) {
		return sqlSessionTemplate.selectOne("products_group_list_count", prduct_ctgry_group);
	}
	
	// 전체 상품 갯수
	public int getProductsCount(String ctgry_nm) {
		return sqlSessionTemplate.selectOne("products_list_count", ctgry_nm);
	}
	
	// 상품 정보 가져오기(그룹, 대분류)
	public List<ProductsDTO> getProductsList(int prduct_ctgry_group, int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("prduct_ctgry_group", prduct_ctgry_group);
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("products_group_list", map);
	}
	
	// 상품 정보 가져오기(네임, 소분류)
	public List<ProductsDTO> getProductsList(String ctgry_nm, int begin, int end) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ctgry_nm", ctgry_nm);
		map.put("begin", String.valueOf(begin));
		map.put("end", String.valueOf(end));
		return sqlSessionTemplate.selectList("products_list", map);
	}
	
	// 하나의 상품 정보 가져오기
	public ProductsDTO getProduct(String prduct_sq) {
		return sqlSessionTemplate.selectOne("product", prduct_sq);
	}
		
	// 상품 리뷰 갯수
	public int getReviewsCount() {
		return sqlSessionTemplate.selectOne("reviews_count");
	}
	
	// 상품 색상 가져오기
	public List<String> getColors(String prduct_sq) {
		return sqlSessionTemplate.selectList("colors", prduct_sq);
	}
	
	// 상품 이미지 가져오기
	public List<ImagesDTO> getProductImages(String prduct_sq) {
		return sqlSessionTemplate.selectList("product_img_list", prduct_sq);
	}
	
	// 상품 조회수 업
	public int getProductViewCntUp(String prduct_sq) {
		return sqlSessionTemplate.update("product_view_cnt_up", prduct_sq);
	}
	
	// 장바구니 중복 체크
	public int getCartOverlap(Map<String, Object> map) {
		return sqlSessionTemplate.selectOne("cart_overlap", map);
	}
	
	// 장바구니 수량 추가
	public int getCartAmtUpdate(Map<String, Object> map) {
		return sqlSessionTemplate.update("cart_amt_update", map);
	}
	
	// 장바구니 추가
	public int getAddCart(Map<String, Object> map) {
		return sqlSessionTemplate.insert("add_cart", map);
	}
	
	// 장바구니 업데이트
	public int getCartUpdate(Map<String, String> map) {
		return sqlSessionTemplate.update("edit_cart", map);
	}	
	
	/*////////////////////////////////// 상품 관리 //////////////////////////////////*/
	
	// 전체 상품 갯수
	public int getProductsCount() {
		return sqlSessionTemplate.selectOne("products_count");
	}
	
	// 전체 상품 정보 가져오기
	public List<ProductsDTO> getProductsList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("products", map);
	}
	
	// 상품 and조건 검색 결과 인원
	public int getProductsAndCount(ProductsSearchDTO productsSearchDTO) {
		return sqlSessionTemplate.selectOne("products_and_count", productsSearchDTO);
	}
	
	// 상품 or조건 검색 결과 인원
	public int getProductsOrCount(ProductsSearchDTO productsSearchDTO) {
		return sqlSessionTemplate.selectOne("products_or_count", productsSearchDTO);
	}
	
	// 상품 and조건 검색
	public List<ProductsDTO> getProductsAndSearch(ProductsSearchDTO productsSearchDTO){
		return sqlSessionTemplate.selectList("products_and_search", productsSearchDTO);
	}
	
	// 상품 or조건 검색
	public List<ProductsDTO> getProductsOrSearch(ProductsSearchDTO productsSearchDTO){
		return sqlSessionTemplate.selectList("products_or_search", productsSearchDTO);
	}
	
	// 상품 정보 수정
	public int getProductsUpdate(ProductsDTO productsDTO) {
		return sqlSessionTemplate.delete("products_update", productsDTO);
	}
	
	public int getAddProduct(ProductsDTO productsDTO) {
		return sqlSessionTemplate.insert("add_product", productsDTO);
	}
	
	public int getAddImg(ImagesDTO imagesDTO) {
		return sqlSessionTemplate.insert("add_img", imagesDTO);
	}
	
	
	/*////////////////////////////////// 회원 정보 관리 //////////////////////////////////*/	
	
	// 전체 회원 숫자
	public int getMbersCount() {
		return sqlSessionTemplate.selectOne("mbers_count");
	}
	
	// 회원 정보 가져오기
	public List<MbersDTO> getMbersList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("members", map);
	}
	
	// 회원 and조건 검색 결과 인원
	public int getMbersAndCount(MbersSearchDTO mbersSearchDTO) {
		return sqlSessionTemplate.selectOne("mbers_and_count", mbersSearchDTO);
	}
		
	// 회원 or조건 검색 결과 인원
	public int getMbersOrCount(MbersSearchDTO mbersSearchDTO) {
		return sqlSessionTemplate.selectOne("mbers_or_count", mbersSearchDTO);
	}

	// 회원 and조건 검색
	public List<MbersDTO> getMbersAndSearch(MbersSearchDTO mbersSearchDTO) {
		return sqlSessionTemplate.selectList("mbers_and_search", mbersSearchDTO);
	}

	// 회원 or조건 검색
	public List<MbersDTO> getMbersOrSearch(MbersSearchDTO mbersSearchDTO) {
		return sqlSessionTemplate.selectList("mbers_or_search", mbersSearchDTO);
	}

	// 회원 정보 수정
	public int getMbersUpdate(MbersDTO mbersDTO) {
		return sqlSessionTemplate.update("mbers_update", mbersDTO);
	}

	// 회원 탈퇴(관리자)
	public int getMbersWithdrawal(String mber_sn) {
		return sqlSessionTemplate.delete("mbers_withdrawal_admin", mber_sn);
	}
	
	
	/*////////////////////////////////// 공지사항 관리 //////////////////////////////////*/

	
	// 전체 공지 갯수
	public int getNotsCount() {
		return sqlSessionTemplate.selectOne("nots_count");
	}
	
	// 공지사항 가져오기
	public List<NotsDTO> getNotsList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("notices", map);
	}
	
	// 공지사항 and조건 검색 결과 인원
	public int getNotsAndCount(NotsSearchDTO notsSearchDTO) {
		return sqlSessionTemplate.selectOne("nots_and_count", notsSearchDTO);
	}
			
	// 공지사항 or조건 검색 결과 인원
	public int getNotsOrCount(NotsSearchDTO notsSearchDTO) {
		return sqlSessionTemplate.selectOne("nots_or_count", notsSearchDTO);
	}

	// 공지사항 and조건 검색
	public List<NotsDTO> getNotsAndSearch(NotsSearchDTO notsSearchDTO) {
		return sqlSessionTemplate.selectList("nots_and_search", notsSearchDTO);
	}

	// 공지사항 or조건 검색
	public List<NotsDTO> getNotsOrSearch(NotsSearchDTO notsSearchDTO) {
		return sqlSessionTemplate.selectList("nots_or_search", notsSearchDTO);
	}
	
	// 공지사항 삭제
	public int getNotsDelete(String not_sn) {
		return sqlSessionTemplate.delete("nots_delete", not_sn);
	}
	
	
	/*////////////////////////////////// 고객 문의 관리 //////////////////////////////////*/
	
	
	// 전체 문의 갯수
	public int getQnaCount() {
		return sqlSessionTemplate.selectOne("qna_count");
	}
	
	// 고객 문의 가져오기
	public List<QnaDTO> getQnaList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("qna", map);
	}
	
	// 고객 문의 and조건 검색 결과 인원
	public int getQnaAndCount(QnaSearchDTO qnaSearchDTO) {
		return sqlSessionTemplate.selectOne("qna_and_count", qnaSearchDTO);
	}
			
	// 고객 문의 or조건 검색 결과 인원
	public int getQnaOrCount(QnaSearchDTO qnaSearchDTO) {
		return sqlSessionTemplate.selectOne("qna_or_count", qnaSearchDTO);
	}

	// 고객 문의 and조건 검색
	public List<QnaDTO> getQnaAndSearch(QnaSearchDTO qnaSearchDTO) {
		return sqlSessionTemplate.selectList("qna_and_search", qnaSearchDTO);
	}

	// 고객 문의 or조건 검색
	public List<QnaDTO> getQnaOrSearch(QnaSearchDTO qnaSearchDTO) {
		return sqlSessionTemplate.selectList("qna_or_search", qnaSearchDTO);
	}
		
	// 고객 문의 삭제
	public int getQnaDelete(String qna_sn) {
		return sqlSessionTemplate.delete("qna_delete", qna_sn);
	}
	
	// 고객 문의 보기
	public QnaDTO getQnaView(String qna_sn) {
		return sqlSessionTemplate.selectOne("qna_view", qna_sn);
	}
	
	// 고객 문의 조회수 업데이트
	public int getQnaRdcntUpdate(QnaDTO qnaDTO) {
		return sqlSessionTemplate.update("qna_rdcnt_update", qnaDTO);
	}
	
		
	/*////////////////////////////////// FAQ 관리 //////////////////////////////////*/
	
	
	// 전체 FAQ 갯수
	public int getFaqCount() {
		return sqlSessionTemplate.selectOne("faq_count");
	}
	
	// FAQ 가져오기
	public List<FaqDTO> getFaqList(int begin, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("faq", map);
	}
	
	// FAQ and조건 검색 결과 인원
	public int getFaqAndCount(FaqSearchDTO faqSearchDTO) {
		return sqlSessionTemplate.selectOne("faq_and_count", faqSearchDTO);
	}
			
	// FAQ or조건 검색 결과 인원
	public int getFaqOrCount(FaqSearchDTO faqSearchDTO) {
		return sqlSessionTemplate.selectOne("faq_or_count", faqSearchDTO);
	}

	// FAQ and조건 검색
	public List<FaqDTO> getFaqAndSearch(FaqSearchDTO faqSearchDTO) {
		return sqlSessionTemplate.selectList("faq_and_search", faqSearchDTO);
	}

	// FAQ or조건 검색
	public List<FaqDTO> getFaqOrSearch(FaqSearchDTO faqSearchDTO) {
		return sqlSessionTemplate.selectList("faq_or_search", faqSearchDTO);
	}
		
	// FAQ 삭제
	public int getFaqDelete(String faq_sn) {
		return sqlSessionTemplate.delete("faq_delete", faq_sn);
	}
	
	// FAQ 보기
	public FaqDTO getFaqView(String faq_sn) {
		return sqlSessionTemplate.selectOne("faq_view", faq_sn);
	}
	
}
